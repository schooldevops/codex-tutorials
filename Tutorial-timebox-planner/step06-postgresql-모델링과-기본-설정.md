# Step 06 - PostgreSQL 모델링과 기본 설정

## Step 목표
- Time-Box Planner 도메인을 PostgreSQL 스키마로 명확히 모델링한다.
- Flyway/jOOQ 실행 순서를 팀 표준으로 고정한다.

## 이번 Step 완료 기준 (DoD)
- [x] DB 모델링 문서가 생성되었다.
- [x] 로컬 DB 초기화/마이그레이션/jOOQ 생성 스크립트가 추가되었다.
- [x] 스크립트 문법 검증이 통과했다.
- [x] Flyway/jOOQ 실행 경로가 문서화되었다.

## 구현 항목
1. `docs/db-modeling.md` 생성
  - 엔티티/관계/제약조건
  - 인덱스 전략
  - 상태값/우선순위 enum 정책
2. `apps/backend/scripts/db-init.sh` 추가
  - `db-up.sh` 실행
  - `flywayMigrate` 실행
  - `generateJooq` 실행

## 검증
- `sh -n apps/backend/scripts/db-init.sh`
- `gradle -p apps/backend -m flywayMigrate generateJooq`

## 다음 Step 예고
- Step07에서 jOOQ 생성 결과를 실제 Repository 쿼리와 매핑해 CRUD 구현을 시작한다.
