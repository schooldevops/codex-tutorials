# Step 05 - OpenAPI 기반 Spring Server Stub 생성

## Step 목표
- OpenAPI로 생성된 서버 인터페이스를 `apps/backend`에서 직접 구현 가능한 구조로 편입한다.
- 백엔드 계층(`Controller -> Service -> Repository`) 골격을 생성한다.

## 이번 Step 완료 기준 (DoD)
- [x] `apps/backend` Gradle 프로젝트 설정이 생성되었다.
- [x] 생성 API 인터페이스를 사용하는 Controller 골격이 생성되었다.
- [x] Service/Repository 스켈레톤이 생성되었다.
- [x] `gradle test`가 성공한다.

## 구현 요약
1. `apps/backend/build.gradle`, `settings.gradle` 추가
2. `sourceSets`에 `packages/openapi/generated/backend/src/main/java` 포함
3. `TimeboxApiController` 추가 (`ApiApi` 구현)
4. `TimeBoxService/TagService/SummaryService` + 구현체 추가
5. `TimeBoxRepository/TagRepository` + jOOQ 구현체 골격 추가

## 검증
- 명령: `JAVA_HOME=$HOME/.sdkman/candidates/java/21.0.9-amzn PATH=$JAVA_HOME/bin:$PATH gradle -p apps/backend test`
- 결과: `BUILD SUCCESSFUL`

## 추가 진행 (2단계) - PostgreSQL/Flyway/jOOQ 연결
- [x] `application.yml`에 datasource/flyway/jooq 기본 설정 반영
- [x] Flyway 초기 마이그레이션(`V1__init_timebox_schema.sql`) 추가
- [x] Gradle에 Flyway/jOOQ 플러그인 및 설정 추가
- [x] `flywayMigrate`, `generateJooq` 태스크 dry-run 성공

### 2단계 검증
- 명령: `JAVA_HOME=$HOME/.sdkman/candidates/java/21.0.9-amzn PATH=$JAVA_HOME/bin:$PATH gradle -p apps/backend test`
- 결과: `BUILD SUCCESSFUL`
- 명령: `JAVA_HOME=$HOME/.sdkman/candidates/java/21.0.9-amzn PATH=$JAVA_HOME/bin:$PATH gradle -p apps/backend -m flywayMigrate generateJooq`
- 결과: `:flywayMigrate SKIPPED`, `:generateJooq SKIPPED`, `BUILD SUCCESSFUL`

## 추가 진행 (3단계) - 로컬 DB 실행 + jOOQ 예시 쿼리
- [x] `apps/backend/docker-compose.yml` 추가 (PostgreSQL 16)
- [x] `apps/backend/scripts/db-up.sh`, `db-down.sh`, `db-logs.sh` 추가
- [x] `apps/backend/.env.example` 추가
- [x] `TimeBoxRepository`에 일자별 집계 메서드 추가
- [x] `JooqTimeBoxRepository`에 DSLContext 기반 예시 쿼리 구현
- [x] `SummaryServiceImpl`에서 리포지토리 집계값 반환 구현

## 다음 Step 예고
- Step06에서 PostgreSQL + Flyway + jOOQ 생성 흐름을 실제 연결한다.
