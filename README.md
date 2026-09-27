## 실행 방법
### 실행 환경
- **JDK**: Java 21
- **Framework**: Spring Boot 4.1.1
- **ORM**: Spring Data JPA
- **Database**: MYSQL

### DB 설정 (application.yaml)
- **URL**: jdbc:mysql://localhost:3306/commerce_db
- **USERNAME**: YOUR_USERNAME
- **PASSWORD**: YOUR_PASSWORD
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ddd_commerce?useSSL=false&serverTimezone=Asia/Seoul
    username: YOUR_USERNAME
    password: YOUR_PASSWORD
```
### 실행 명령
```bash
./gradlew bootRun
```

## 구조
### 모듈 구조
```text
com.back
├── boundedContext          
│   ├── member              
│   │   ├── in : ApiV1MemberController, MemberDataInit, MemberEventListener
│   │   ├── app : MemberFacade, MemberGetTipUseCase, MemberIncreaseScoreUseCase, MemberJoinUseCase
│   │   ├── domain : Member, MemberPolicy
│   │   ├── dto : MemberDto
│   │   └── out : MemberRepository
│   │
│   └── post
│       ├── in : PostDataInit, PostEventListener
│       ├── app : PostCommentWriteUseCase, PostFacade, PostWriteUseCase
│       ├── domain : Post, PostComment, PostMember
│       ├── dto : PostCommentDto, PostDto
│       └── out : PostMemberRepository, PostRepository
│
├── global
│   ├── entity : BaseEntity, BaseGeneratedInfo
│   ├── exception : DomainException
│   └── response : RsData
│
└── shared
    ├── member
    │   ├── domain : BaseMember, ReplicaMember, SourceMember
    │   ├── event : MemberJoinEvent
    │   └── out : MemberApiClient
    └── post 
        └── event : CreatePostCommentEvent, CreatePostEvent
```
### 이벤트와 HTTP API를 구분한 이유
- 이벤트 방식은 처리 결과를 즉시 반환받기 어렵기 때문에 즉시 응답이 필요한 경우에는 HTTP API 방식을 활용함
### 회원 복제 흐름
#### 회원가입
1. Member : 회원 생성 → 회원 생성 이벤트 발행 
2. Post : 회원 생성 이벤트 수신 → 회원 복제 데이터 생성
#### 회원점수 증가
1. Post : 글(댓글) 작성 → 글(댓글) 작성완료 이벤트 발행
2. Member : 글(댓글) 작성완료 이벤트 수신 → 회원점수 증가 → 회원 수정 이벤트 발행
3. Post : 회원 수정 이벤트 수신 → 회원 복제 데이터 업데이트

## 확인결과

### 초기 데이터
- **회원 (Member):** 6명 (`system`, `holding`, `admin`, `user1`, `user2`, `user3`)
- **글 (Post):** 6개 (`user1` 3개, `user2` 2개, `user3` 1개)
- **댓글 (Comment):** (`user1`2개, `user2` 3개, `user3` 3개)
### 활동점수
- `user1` : 11점
- `user2` : 9점
- `user3` : 6점
### 원본과 복제본의 일치여부 확인
```text
select * from MEMBER_MEMBER;
select * from POST_MEMBER;
```
### 보안팁 호출결과
```text
1번 글이 생성되었습니다. 보안 팁 : 비밀번호의 유효기간은 90일 입니다.
```