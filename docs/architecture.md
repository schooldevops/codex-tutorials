# Time-Box Planner 아키텍처/구조 설계 (Step02 산출물)

## 1. 모노레포 구조
```text
.
├─ apps/
│  ├─ frontend/
│  └─ backend/
├─ packages/
│  ├─ openapi/
│  │  ├─ spec/
│  │  └─ generated/
│  │     ├─ frontend/
│  │     └─ backend/
│  └─ db/
│     ├─ migrations/
│     ├─ seed/
│     └─ jooq/
├─ docs/
└─ scripts/
```

## 2. 데이터/요청 흐름
1. 프런트(Next.js) -> Axios Client(생성 코드) 호출
2. 백엔드 Controller(생성 인터페이스 구현) 수신
3. Service에서 비즈니스 규칙 처리
4. Repository(jOOQ)에서 PostgreSQL 조회/저장
5. 응답 DTO 반환

## 3. OpenAPI Contract-First 워크플로우
1. `packages/openapi/spec/*.yaml` 수정
2. 프런트/백엔드 생성 코드 갱신
3. 백엔드 구현체/프런트 UI 로직 반영
4. 테스트 및 계약 검증

## 4. 생성 명령(초안)
```bash
# frontend client
openapi-generator-cli generate \
  -i packages/openapi/spec/timebox-planner.openapi.yaml \
  -g typescript-axios \
  -o packages/openapi/generated/frontend

# backend stub
openapi-generator-cli generate \
  -i packages/openapi/spec/timebox-planner.openapi.yaml \
  -g spring \
  -o packages/openapi/generated/backend \
  --additional-properties=interfaceOnly=true,useSpringBoot3=true
```

## 5. 백엔드 계층 책임
- Controller: API 입출력 변환, HTTP 상태 처리
- Service: 도메인 규칙, 유효성/트랜잭션
- Repository: DB 접근(jOOQ DSL)

## 6. DB 운영 원칙
- 마이그레이션 파일로 스키마 변경 이력 관리
- jOOQ 코드 생성 시점: 마이그레이션 적용 직후
- 시간 컬럼은 UTC 저장, UI 표현 시 timezone 변환

## 7. Step03 진입 조건
- OpenAPI 파일 경로 확정
- 생성 경로 확정
- 컨트롤러/서비스/리포지토리 책임 경계 합의
