# Step 04 - OpenAPI 기반 프런트 타입과 Axios 클라이언트 생성

## Step 목표
- 생성된 `typescript-axios` 코드를 앱에서 재사용 가능한 API 레이어로 연결한다.
- 환경변수 기반 API base URL 설정을 표준화한다.

## 이번 Step 완료 기준 (DoD)
- [x] 프런트 API 설정 파일이 생성되었다.
- [x] TimeBox API 클라이언트 래퍼가 생성되었다.
- [x] 프런트 환경 변수 예시 파일이 생성되었다.
- [x] 다음 단계(UI 연결)에서 바로 사용할 준비가 되었다.

## 1) 생성 코드 재사용 원칙
- `packages/openapi/generated/frontend`는 생성 전용 경로로 유지한다.
- 앱에서는 생성 코드를 직접 수정하지 않고 래퍼를 통해 호출한다.
- 공통 설정(인증 헤더, baseURL)은 래퍼 레이어에서 주입한다.

## 2) 구현 항목
1. `apps/frontend/src/lib/api/config.ts`
- axios 설정 및 basePath 계산

2. `apps/frontend/src/lib/api/timeboxClient.ts`
- 생성된 `TimeBoxesApi`, `TagsApi`, `SummaryApi`를 캡슐화

3. `apps/frontend/.env.example`
- `NEXT_PUBLIC_API_BASE_URL` 샘플 추가

## 3) 체크리스트
- [ ] `NEXT_PUBLIC_API_BASE_URL` 미설정 시 기본값 동작 확인
- [ ] 각 API 인스턴스 생성이 정상 동작
- [ ] 이후 페이지/훅에서 import 가능한 경로 정리

## 다음 Step 예고
- Step05에서 Spring server stub를 `apps/backend`로 편입하고 구현체 골격을 만든다.
