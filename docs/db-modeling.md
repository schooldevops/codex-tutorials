# Time-Box Planner DB 모델링 (Step06 산출물)

## 1) 엔티티
- `user_account`
  - 사용자 기본 정보
- `time_box`
  - 일정 블록 본문
- `tag`
  - 사용자별 태그
- `time_box_tag`
  - `time_box` : `tag` N:M 관계

## 2) 관계
- `user_account(1) -> time_box(N)`
- `user_account(1) -> tag(N)`
- `time_box(N) <-> tag(N)` via `time_box_tag`

## 3) 제약조건
- `time_box.start_at < time_box.end_at`
- `tag`는 사용자 기준 이름 unique (`UNIQUE(user_id, name)`)
- `time_box_tag`는 복합 PK(`time_box_id`, `tag_id`)

## 4) 인덱스
- `idx_time_box_user_start_at(user_id, start_at)`
- `idx_time_box_user_status(user_id, status)`

## 5) 시간/타임존 정책
- DB 저장: UTC (`TIMESTAMPTZ`)
- API 전송: ISO-8601 (`OffsetDateTime`)
- 화면 표시: 사용자 timezone 변환

## 6) 상태/우선순위 정책
- 상태: `PLANNED`, `IN_PROGRESS`, `DONE`, `CANCELLED`
- 우선순위: `LOW`, `MEDIUM`, `HIGH`

## 7) 실행 순서 표준
1. `apps/backend/scripts/db-up.sh`
2. `gradle -p apps/backend flywayMigrate`
3. `gradle -p apps/backend generateJooq`
4. 서버 기동 후 API 테스트

## 8) 로컬 환경 변수
- `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD`
- 기본값은 `apps/backend/.env.example` 참고
