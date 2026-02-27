# Time-Box Planner 요구사항 정의서 (Step01 산출물)

## 1. 프로젝트 목표

### 1-1. 제품 한 줄 정의
Time-Box Planner는 개인 지식노동자가 하루 업무를 시간 단위 블록으로 계획/실행/회고하여 집중 시간을 높이고 일정 누락을 줄이도록 돕는 서비스다.

### 1-2. 성공 기준 (MVP, 4주)
- 활성 사용자(주간): 30명 이상
- 시간블록 생성 완료율: 70% 이상
- 주간 재방문율: 40% 이상

## 2. 타겟 사용자

### 사용자 유형 A: 개발자/엔지니어
- 상황: 여러 업무를 병행하며 우선순위 전환이 잦다.
- 주요 목표: 하루 계획을 시간블록으로 나누고 완료율을 높인다.
- 불편: 할 일 목록은 있지만 실제 시간 배분이 안 되어 집중이 깨진다.

### 사용자 유형 B: 기획/운영 담당자
- 상황: 회의와 문서 업무가 혼재되어 예측이 어렵다.
- 주요 목표: 업무 시간을 가시화하고 예정보다 지연되는 작업을 줄인다.
- 불편: 계획 대비 실행 차이를 추적하기 어렵다.

## 3. 핵심 시나리오

### 시나리오 1: 오늘 시간블록 생성
- 시작 상태: 사용자가 오늘 계획이 없는 상태
- 사용자 행동: 제목, 시작/종료 시간, 우선순위를 입력해 시간블록을 생성
- 종료 상태: 일정에 신규 블록이 저장되고 목록/타임라인에서 조회 가능
- 성공 조건: 생성 응답 성공 + 목록 조회 시 즉시 확인

### 시나리오 2: 시간블록 수정/재배치
- 시작 상태: 기존 블록이 존재
- 사용자 행동: 시간/제목/상태를 수정
- 종료 상태: 변경 내역이 반영되고 최신 데이터가 화면에 동기화
- 성공 조건: 수정 API 성공 + 조회 데이터 일관성 유지

### 시나리오 3: 하루 회고
- 시작 상태: 하루 블록이 다수 존재
- 사용자 행동: 완료/미완료 상태를 갱신하고 요약 통계를 확인
- 종료 상태: 완료 개수, 집중 시간(총 완료 시간)이 계산되어 표시
- 성공 조건: 통계가 상태 변경 후 즉시 업데이트

## 4. MVP 범위

### 4-1. In Scope
1. 시간블록 CRUD
2. 날짜 기준 목록 조회
3. 상태 변경(`PLANNED`, `IN_PROGRESS`, `DONE`, `CANCELLED`)
4. 기본 통계(완료 블록 수, 총 계획 시간, 총 완료 시간)
5. 태그 연결(선택) 및 태그 필터 조회

### 4-2. Out of Scope
1. 팀 협업/공유 및 멀티 사용자 권한 관리
2. Google/Outlook 캘린더 양방향 연동
3. 실시간 동시 편집(WebSocket)
4. 고급 리포트/추천 알고리즘

## 5. 도메인 엔티티 초안

## 5-1. User
- id (UUID, PK)
- email (string, unique)
- displayName (string)
- timezone (string, 예: `Asia/Seoul`)
- createdAt, updatedAt (timestamp with time zone)

## 5-2. TimeBox
- id (UUID, PK)
- userId (UUID, FK -> User.id)
- title (string, 1~120)
- description (string, optional, 최대 2000)
- startAt (timestamp with time zone)
- endAt (timestamp with time zone)
- status (enum: `PLANNED`, `IN_PROGRESS`, `DONE`, `CANCELLED`)
- priority (enum: `LOW`, `MEDIUM`, `HIGH`)
- completedAt (timestamp with time zone, optional)
- createdAt, updatedAt (timestamp with time zone)

## 5-3. Tag
- id (UUID, PK)
- userId (UUID, FK -> User.id)
- name (string, unique per user)
- color (string, optional, hex)
- createdAt, updatedAt

## 5-4. TimeBoxTag (N:M 연결)
- timeBoxId (UUID, FK -> TimeBox.id)
- tagId (UUID, FK -> Tag.id)
- primary key (timeBoxId, tagId)

## 6. 비즈니스 규칙
1. `startAt < endAt` 이어야 한다.
2. 단일 사용자의 동일 시간대 중복 블록은 MVP에서 허용한다(추후 경고 정책 추가 가능).
3. `status = DONE` 변경 시 `completedAt`은 서버 시각으로 자동 설정한다.
4. `status != DONE`로 되돌리면 `completedAt`은 null 처리한다.
5. 삭제는 Hard Delete를 기본으로 한다(MVP). 추후 Soft Delete 확장 가능.
6. 모든 시간 데이터는 DB에서 UTC로 저장하고, UI 표시 시 사용자 timezone으로 변환한다.

## 7. API 후보 목록 (OpenAPI 입력용)

### 7-1. TimeBox API
1. `POST /api/v1/time-boxes`
- 목적: 시간블록 생성

2. `GET /api/v1/time-boxes`
- 목적: 목록 조회
- 쿼리 후보: `date`, `from`, `to`, `status`, `tagId`, `page`, `size`

3. `GET /api/v1/time-boxes/{id}`
- 목적: 단건 상세 조회

4. `PATCH /api/v1/time-boxes/{id}`
- 목적: 부분 수정(시간, 제목, 상태, 우선순위, 설명)

5. `DELETE /api/v1/time-boxes/{id}`
- 목적: 삭제

### 7-2. Tag API (MVP 최소)
1. `POST /api/v1/tags`
2. `GET /api/v1/tags`
3. `DELETE /api/v1/tags/{id}`

### 7-3. Summary API
1. `GET /api/v1/summary/daily`
- 목적: 특정 일자의 계획/완료 통계 반환

## 8. 요청/응답 초안

### 8-1. 시간블록 생성 요청 예시
```json
{
  "title": "API 명세 작성",
  "description": "OpenAPI 초안 1차",
  "startAt": "2026-03-01T09:00:00+09:00",
  "endAt": "2026-03-01T10:30:00+09:00",
  "priority": "HIGH",
  "tagIds": ["3e4f2d62-1b3a-4a2e-b989-12a6f47c1d21"]
}
```

### 8-2. 시간블록 단건 응답 예시
```json
{
  "id": "9d8725be-cf3d-4d77-bf8a-20d70a5864d8",
  "userId": "f6ce50bf-7221-4e4a-a214-f4fd8c7ea31f",
  "title": "API 명세 작성",
  "description": "OpenAPI 초안 1차",
  "startAt": "2026-03-01T00:00:00Z",
  "endAt": "2026-03-01T01:30:00Z",
  "status": "PLANNED",
  "priority": "HIGH",
  "completedAt": null,
  "tags": [
    { "id": "3e4f2d62-1b3a-4a2e-b989-12a6f47c1d21", "name": "문서", "color": "#2563EB" }
  ],
  "createdAt": "2026-03-01T00:00:10Z",
  "updatedAt": "2026-03-01T00:00:10Z"
}
```

### 8-3. 공통 에러 응답 예시
```json
{
  "code": "INVALID_TIME_RANGE",
  "message": "startAt must be before endAt",
  "requestId": "a145e0a3-5513-4e7e-8f67-29b4bb20f8bc",
  "timestamp": "2026-03-01T00:00:11Z"
}
```

## 9. 비기능 요구사항
1. 성능: 목록 조회 API p95 500ms 이하 (단일 사용자 기준)
2. 신뢰성: 서버 예외는 공통 에러 포맷으로 반환
3. 관측성: 모든 요청에 `requestId` 로깅, userId/endpoint/status 기록
4. 보안: MVP는 단일 사용자 모드(고정 테스트 사용자)로 시작, 이후 JWT 확장
5. 테스트 기준: 핵심 도메인 규칙(`startAt < endAt`, status 전환) 단위 테스트 필수

## 10. Step01 체크 결과
- [x] 프로젝트 목표 정의 완료
- [x] 사용자/시나리오 정의 완료
- [x] MVP In/Out Scope 정의 완료
- [x] 도메인 엔티티/규칙 초안 완료
- [x] OpenAPI 입력 정보(엔드포인트/스키마 초안) 완료
- [x] 비기능 요구사항 정의 완료

## 11. 다음 Step 입력값
다음 step(`step02-기술스택과-모노레포-구조-설계`)에서 확정할 내용:
1. 모노레포 구조(`apps/frontend`, `apps/backend`, `packages/openapi` 등)
2. OpenAPI 파일 위치 및 코드 생성 명령
3. Spring Boot/jOOQ/PostgreSQL 초기 프로젝트 구성
4. Next.js/Tailwind/Axios 클라이언트 생성 파이프라인
