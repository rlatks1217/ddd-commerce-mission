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