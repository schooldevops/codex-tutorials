# Step 02 - 기술스택과 모노레포 구조 설계

## Step 목표
- Step01 요구사항을 구현 가능한 저장소 구조로 변환한다.
- 프런트/백엔드/DB/OpenAPI 산출물의 위치와 생성 파이프라인을 확정한다.
- Step03(OpenAPI 명세 작성)에서 바로 작업 가능한 기준 구조를 만든다.

## 이번 Step 완료 기준 (DoD)
- [x] 기술 스택 세부 버전/역할이 문서화되었다.
- [x] 모노레포 디렉토리 구조가 확정되었다.
- [x] OpenAPI 원본/생성물 위치가 정의되었다.
- [x] 프런트 코드 생성(axios + typescript) 명령이 정의되었다.
- [x] 백엔드 server stub 생성 명령이 정의되었다.
- [x] DB(PostgreSQL + jOOQ + 마이그레이션) 흐름이 정의되었다.
- [x] 산출물 파일(`docs/stack.md`, `docs/architecture.md`)이 생성되었다.

## 사전 준비
- [ ] step02 브랜치(worktree)에서 작업 중인지 확인
- [ ] step01 산출물(`docs/requirements.md`) 최신 상태 확인

실행 명령:
```bash
pwd
git status -sb
ls docs
```

## 1) 기술 스택 고정

### 1-1. 프런트엔드
- Framework: Next.js (React, App Router)
- Language: TypeScript
- UI: Tailwind CSS
- HTTP: Axios
- API Contract Client: OpenAPI Generator(`typescript-axios`)

체크:
- [ ] API 호출 코드는 수동 타입 작성이 아닌 생성 코드 기반으로 사용한다.
- [ ] UI 레이어와 API 클라이언트 레이어를 분리한다.

### 1-2. 백엔드
- Framework: Spring Boot
- Language: Java/Kotlin 중 1개 (튜토리얼은 Java 기준)
- AI 기능: Spring AI
- Data Access: jOOQ
- API Contract Server: OpenAPI Generator(`spring`) server stub

체크:
- [ ] 컨트롤러는 생성된 API 인터페이스를 구현한다.
- [ ] 비즈니스 로직은 Service 계층에 집중한다.
- [ ] SQL/DB 접근은 Repository(jOOQ)로 통일한다.

### 1-3. 데이터베이스
- DBMS: PostgreSQL
- Migration: Flyway(권장) 또는 Liquibase
- SQL 접근: jOOQ code generation

체크:
- [ ] DDL은 마이그레이션으로 관리한다.
- [ ] jOOQ 생성 코드는 DB 스키마와 동기화한다.

## 2) 모노레포 구조 정의

권장 구조:
```text
.
├─ apps/
│  ├─ frontend/              # Next.js
│  └─ backend/               # Spring Boot
├─ packages/
│  ├─ openapi/               # OpenAPI 원본/생성물
│  │  ├─ spec/               # source of truth
│  │  ├─ generated/frontend/ # typescript-axios output
│  │  └─ generated/backend/  # spring server stub output
│  └─ db/                    # DDL, migration, seed
├─ docs/
│  ├─ requirements.md
│  ├─ stack.md
│  └─ architecture.md
└─ scripts/
```

체크:
- [ ] OpenAPI 원본(spec)과 생성물(generated)을 분리했다.
- [ ] 앱 코드와 공유 산출물 위치가 명확하다.

## 3) OpenAPI 기반 생성 파이프라인 정의

## 3-1. OpenAPI 원본 위치
- 파일: `packages/openapi/spec/timebox-planner.openapi.yaml`
- 원칙: 스펙 변경이 코드 변경보다 먼저 일어난다.

## 3-2. 프런트 생성 명령 (typescript-axios)
예시:
```bash
openapi-generator-cli generate \
  -i packages/openapi/spec/timebox-planner.openapi.yaml \
  -g typescript-axios \
  -o packages/openapi/generated/frontend \
  --additional-properties=withInterfaces=true,typescriptThreePlus=true
```

## 3-3. 백엔드 생성 명령 (spring server stub)
예시:
```bash
openapi-generator-cli generate \
  -i packages/openapi/spec/timebox-planner.openapi.yaml \
  -g spring \
  -o packages/openapi/generated/backend \
  --additional-properties=interfaceOnly=true,useSpringBoot3=true
```

체크:
- [ ] 스펙 파일 한 곳에서 프런트/백엔드 생성이 가능하다.
- [ ] 생성 코드를 직접 수정하지 않고 구현 코드를 분리한다.

## 4) 백엔드 계층 구현 전략
- Controller: 생성된 인터페이스 구현체
- Service: 도메인 규칙/트랜잭션
- Repository: jOOQ DSL 기반 쿼리
- Mapper: API DTO <-> 도메인 모델 변환

체크:
- [ ] 컨트롤러에서 DB 접근 금지
- [ ] 서비스에서 입력 검증/비즈니스 규칙 처리

## 5) DB + jOOQ 흐름 설계
1. `packages/db/migrations`에 SQL 작성
2. PostgreSQL에 마이그레이션 적용
3. jOOQ 코드 생성 실행
4. Repository에서 생성된 jOOQ 타입 사용

체크:
- [ ] 마이그레이션 적용 순서가 문서화되었다.
- [ ] jOOQ 재생성 타이밍이 명확하다(스키마 변경 직후).

## 6) 산출물 작성

이 step에서 아래 파일을 작성한다.
- `docs/stack.md`
- `docs/architecture.md`

체크:
- [ ] 팀원이 이 문서만 보고 Step03을 시작할 수 있다.
- [ ] 명령/경로/역할이 모호하지 않다.

## 7) 리뷰 요청 템플릿
```text
step02 기술스택/구조 설계 문서를 작성했습니다.
다음 관점으로 리뷰해주세요:
1) OpenAPI contract-first 흐름이 충분히 명확한지
2) 프런트/백엔드/DB 경계가 분명한지
3) Step03에서 바로 명세 작성 가능한 상태인지
승인되면 step03(OpenAPI 명세 초안 작성)으로 진행하겠습니다.
```

## 최종 체크리스트
- [x] DoD 항목을 모두 완료했다.
- [x] `docs/stack.md`를 작성했다.
- [x] `docs/architecture.md`를 작성했다.
- [x] 다음 step(OpenAPI 명세 작성)으로 넘어갈 준비가 되었다.

## 다음 Step 예고
- `step03-openapi-명세-초안-작성.md`에서 실제 `timebox-planner.openapi.yaml` 초안을 작성한다.
