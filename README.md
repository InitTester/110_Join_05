# 회원가입 실습 5

## 실습 예정

- [x] 1차 : springMVC, JDBC 구현
- [ ] 2차 : springMVC, Mybatis 구현

## 요구사항
- 프로젝트 환경 설정하기
	- servlet
	- spring
	- mybatis
	- logback
- index.html -> login.jsp 로 변환
- css, js 파일 resources tag 설정
- Servlet 구성 및 접속
	- 회원가입 페이지 : /login-Page.do
	- 회원가입 : /sign-up.do
		- 회원ID 6자 이하 가입 불가
		- ID 중복 확인 해보기
		- 회원 테이블에 정보 입력하기
		- 회원 가입 완료 시 웰컴 이메일 발송하기
- 회원가입 성공/실패에 따른 Alert 노출하기
- 로그인 성공/실패에 따른 Alert 노출하기

## 제약조건
- 구현하는 모든 메서드에 주석을 달 것.

```java
/**
 * 회원 찾기
 * 
 * @param memberId 회원ID
 * @param email 회원 이메일
 * @return true/false
 */
public boolean findPasswd(String memberId, String email) {
    // codes
}
```

## Docker DB
```
docker run -p 45432:5432 -e PGDATA=/var/lib/postgresql/pgdata -e POSTGRES_PASSWORD=admin_123 --restart unless-stopped --name postgres-sample -d jyeory/postgres-jdbc-01:0.0.5
```

## UI
![image](https://github.com/InitTester/110_Join_05/assets/143479869/7cb10005-fba8-4fd9-b224-88567e3ccb46)
