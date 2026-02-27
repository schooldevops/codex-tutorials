# Time-Box Planner 튜토리얼 작성 플랜

## 목적
- `time-box planner` 애플리케이션을 처음부터 구현하는 전 과정을 튜토리얼로 문서화한다.
- 각 문서는 `step01-과정명.md` 형식으로 작성한다.
- 각 step은 "왜 하는지", "무엇을 만드는지", "어떻게 검증하는지"를 반드시 포함한다.

## 기술 스택 (확정)
- 프런트엔드: `React`, `Next.js`, `Tailwind CSS`
- 프런트 API 클라이언트: `TypeScript`, `Axios`, `OpenAPI Generator`
- 백엔드: `Spring Boot`, `Spring AI`, `jOOQ`, `PostgreSQL`
- API 계약: `OpenAPI Specification` 우선 설계 (contract-first)
- 코드 생성 전략:
  - 클라이언트: OpenAPI 스펙 기반 TS 인터페이스/클라이언트 생성
  - 서버: OpenAPI 스펙 기반 Spring server stub 생성 후 구현체 연결
- 데이터베이스: `PostgreSQL` + 모델링(ERD/DDL/마이그레이션) + 기본 운영 설정

## 문서 작성 원칙
- 한 step당 하나의 핵심 목표만 다룬다.
- 코드 블록은 복붙 후 바로 실행 가능해야 한다.
- 각 step 마지막에 체크리스트(완료 조건)를 넣는다.
- 다음 step으로 넘어가기 전에 테스트/동작 확인 결과를 남긴다.

## 아키텍처/구현 원칙
- API는 반드시 OpenAPI 스펙을 먼저 작성하고, 이를 단일 진실 소스(SSOT)로 사용한다.
- 프런트/백엔드는 생성된 계약 코드에 맞춰 개발한다.
- 백엔드는 `Controller 구현체 -> Service -> Repository(jOOQ)` 계층으로 구성한다.
- DB 변경은 모델링 문서와 마이그레이션을 동시에 관리한다.
- 각 단계는 "스펙 변경 -> 코드 생성 -> 구현 -> 테스트" 순서를 유지한다.

## 튜토리얼 단계 초안
1. `step01-프로젝트-목표와-요구사항-정의.md`
2. `step02-기술스택과-모노레포-구조-설계.md`
3. `step03-openapi-명세-초안-작성.md`
4. `step04-openapi-기반-프런트-타입과-axios-클라이언트-생성.md`
5. `step05-openapi-기반-spring-server-stub-생성.md`
6. `step06-postgresql-모델링과-기본-설정.md`
7. `step07-jooq-설정과-리포지토리-기초-구현.md`
8. `step08-spring-controller-service-repository-구현.md`
9. `step09-spring-ai-연동-기능-추가.md`
10. `step10-nextjs-react-tailwind-기본-화면-구성.md`
11. `step11-시간블록-crud-프런트백-통합.md`
12. `step12-테스트-품질게이트-운영체크리스트.md`
13. `step13-배포-및-확장-전략.md`

## 프런트엔드 섹션 계획
- Next.js 앱 초기화 및 Tailwind CSS 설정
- OpenAPI 기반 타입/클라이언트 생성 파이프라인 구성
- Axios 인스턴스 공통화(인증/에러 인터셉터)
- React UI(시간블록 생성/목록/수정/삭제/캘린더 뷰)
- 폼 검증, 로딩/에러/빈 상태 처리

## 백엔드 섹션 계획
- Spring Boot 프로젝트 초기화
- OpenAPI 스펙 기준 server stub 생성
- 생성된 인터페이스에 맞춰 Controller 구현체 작성
- Service 계층에 비즈니스 로직 구현
- jOOQ 기반 Repository 계층 구현
- Spring AI 연동 기능(예: 일정 추천/요약) 추가

## 데이터베이스 섹션 계획
- 도메인 모델링(ERD, 엔티티/관계/제약조건)
- PostgreSQL 기본 설정(스키마, 계정, 권한, 타임존)
- 마이그레이션 전략(Flyway/Liquibase 중 선택) 정리
- DDL 작성 및 초기 데이터 시드
- jOOQ 코드 생성 및 모델 매핑 점검

## 각 step 공통 템플릿
- 목표
- 선수 지식/사전 상태
- 구현 내용
- 코드/명령어
- 실행 결과 확인 방법
- 트러블슈팅
- 완료 체크리스트
- 다음 step 예고

## 진행 방식
1. 먼저 `step01` 문서를 작성한다.
2. 사용자 리뷰를 반영한다.
3. 승인 후 다음 step으로 진행한다.

## 이번 턴 제안
- 다음 작업으로 `step01-프로젝트-목표와-요구사항-정의.md` 초안을 작성한다.
