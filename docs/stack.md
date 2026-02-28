# Time-Box Planner 기술 스택 정의 (Step02 산출물)

## 1. 프런트엔드
- Framework: Next.js (React)
- Language: TypeScript
- UI: Tailwind CSS
- HTTP Client: Axios
- API Types/Client: OpenAPI Generator (`typescript-axios`)

## 2. 백엔드
- Framework: Spring Boot
- AI: Spring AI
- Data Access: jOOQ
- Build Tool: Gradle
- API Contract Server: OpenAPI Generator (`spring`, interfaceOnly)
- Runtime DB: PostgreSQL

## 3. 데이터베이스
- DBMS: PostgreSQL
- Migration: Flyway (우선 적용)
- SQL 스키마 변경 후 jOOQ 코드 재생성

## 4. API 계약/생성 전략
- 단일 진실 소스: `packages/openapi/spec/timebox-planner.openapi.yaml`
- 프런트 생성물: `packages/openapi/generated/frontend`
- 백엔드 생성물: `packages/openapi/generated/backend`
- 규칙: 스펙 변경 -> 생성 -> 구현 순서 준수

## 5. 버전/정책
- 언어/프레임워크 세부 버전은 Step03 시작 전 lock
- 생성 코드 직접 수정 금지
- 생성 코드와 구현 코드를 별도 경로로 분리
