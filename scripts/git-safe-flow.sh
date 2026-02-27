#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
Usage:
  git-safe-flow.sh create <name-or-branch> [base-branch]
  git-safe-flow.sh list
  git-safe-flow.sh sync [base-branch]
  git-safe-flow.sh remove <name-or-branch|worktree-path> [--delete-branch]

Commands:
  create  Create a feature worktree under ../worktrees by default.
          - name example: auth-login      -> branch feature/auth-login
          - branch example: feature/auth  -> branch feature/auth
  list    Show all worktrees.
  sync    Rebase current branch onto origin/<base-branch>. Default: main
  remove  Remove a worktree safely, then optionally delete local branch.

Env:
  WORKTREES_DIR  Override default worktree base directory.

Examples:
  ./scripts/git-safe-flow.sh create auth-login
  ./scripts/git-safe-flow.sh create feature/billing main
  ./scripts/git-safe-flow.sh sync main
  ./scripts/git-safe-flow.sh remove auth-login --delete-branch
EOF
}

die() {
  echo "Error: $*" >&2
  exit 1
}

require_git_repo() {
  git rev-parse --show-toplevel >/dev/null 2>&1 || die "Run this inside a git repository."
}

repo_root() {
  git rev-parse --show-toplevel
}

normalize_branch() {
  local input="$1"
  if [[ "$input" == */* ]]; then
    printf '%s\n' "$input"
  else
    printf 'feature/%s\n' "$input"
  fi
}

slug_from_branch() {
  local branch="$1"
  printf '%s\n' "${branch##*/}"
}

is_clean_tree() {
  [[ -z "$(git status --porcelain)" ]]
}

cmd_create() {
  local name_or_branch="${1:-}"
  local base_branch="${2:-main}"
  [[ -n "$name_or_branch" ]] || die "create requires <name-or-branch>."

  local root branch slug wt_base wt_path
  root="$(repo_root)"
  branch="$(normalize_branch "$name_or_branch")"
  slug="$(slug_from_branch "$branch")"
  wt_base="${WORKTREES_DIR:-$root/../worktrees}"
  wt_path="$wt_base/$slug"

  mkdir -p "$wt_base"
  [[ ! -e "$wt_path" ]] || die "Worktree path already exists: $wt_path"

  git fetch origin --prune
  if git show-ref --verify --quiet "refs/heads/$branch"; then
    git worktree add "$wt_path" "$branch"
  else
    git worktree add "$wt_path" -b "$branch" "$base_branch"
  fi

  cat <<EOF
Created worktree:
  path:   $wt_path
  branch: $branch

Next:
  cd "$wt_path"
  git status -sb
EOF
}

cmd_list() {
  git worktree list
}

cmd_sync() {
  local base_branch="${1:-main}"

  git rev-parse --abbrev-ref HEAD >/dev/null 2>&1 || die "Could not detect current branch."
  local current_branch
  current_branch="$(git rev-parse --abbrev-ref HEAD)"
  [[ "$current_branch" != "HEAD" ]] || die "Detached HEAD is not supported for sync."

  is_clean_tree || die "Working tree is not clean. Commit or stash before sync."

  git fetch origin --prune
  git rebase "origin/$base_branch"

  echo "Synced branch '$current_branch' on top of origin/$base_branch"
}

resolve_branch_from_arg() {
  local arg="$1"
  if [[ -d "$arg/.git" ]] || [[ -f "$arg/.git" ]]; then
    git -C "$arg" rev-parse --abbrev-ref HEAD
    return
  fi

  local branch
  branch="$(normalize_branch "$arg")"
  if git show-ref --verify --quiet "refs/heads/$branch"; then
    printf '%s\n' "$branch"
    return
  fi

  die "Could not resolve branch from argument: $arg"
}

resolve_worktree_path_from_branch() {
  local branch="$1"
  local line path found=""

  while IFS= read -r line; do
    path="${line%% *}"
    if git -C "$path" rev-parse --abbrev-ref HEAD 2>/dev/null | grep -qx "$branch"; then
      found="$path"
      break
    fi
  done < <(git worktree list --porcelain | awk '/^worktree / {print $2}')

  [[ -n "$found" ]] || die "No worktree found for branch: $branch"
  printf '%s\n' "$found"
}

cmd_remove() {
  local target="${1:-}"
  local maybe_flag="${2:-}"
  [[ -n "$target" ]] || die "remove requires <name-or-branch|worktree-path>."

  local delete_branch="false"
  if [[ "$maybe_flag" == "--delete-branch" ]]; then
    delete_branch="true"
  elif [[ -n "$maybe_flag" ]]; then
    die "Unknown option: $maybe_flag"
  fi

  local branch wt_path
  branch="$(resolve_branch_from_arg "$target")"
  wt_path="$(resolve_worktree_path_from_branch "$branch")"

  if [[ -n "$(git -C "$wt_path" status --porcelain)" ]]; then
    die "Worktree has uncommitted changes: $wt_path"
  fi

  git worktree remove "$wt_path"
  echo "Removed worktree: $wt_path"

  if [[ "$delete_branch" == "true" ]]; then
    git branch -d "$branch"
    echo "Deleted local branch: $branch"
  fi
}

main() {
  require_git_repo

  local cmd="${1:-}"
  shift || true

  case "$cmd" in
    create) cmd_create "$@" ;;
    list) cmd_list ;;
    sync) cmd_sync "$@" ;;
    remove) cmd_remove "$@" ;;
    -h|--help|help|"") usage ;;
    *) die "Unknown command: $cmd" ;;
  esac
}

main "$@"
