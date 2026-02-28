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

## 다음 Step 예고
- Step06에서 PostgreSQL + Flyway + jOOQ 생성 흐름을 실제 연결한다.
