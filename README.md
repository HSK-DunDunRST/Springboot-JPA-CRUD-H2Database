# 스프링부트 + JPA + Thymeleaf를 사용한 웹서버 및 웹페이지

> 간단한 설명: 이 프로젝트는 Spring Boot, H2 데이터베이스, JPA, 그리고 Thymeleaf를 이용해 개발된 간단한 웹 애플리케이션입니다.
> 
> 참고 사항: 이 프로젝트는 공부용으로 생성된 프로젝트이며, 위키독스 점프 투 스프링 교재를 참고하여 만든 프로젝트 입니다. [![WikiDocs](https://img.shields.io/badge/My_Website-Visit-blue?style=for-the-badge&logo=google-chrome&logoColor=white)](https://wikidocs.net/book/7601)

## 목차
- [프로젝트 소개](#프로젝트-소개)
- [기술 스택](#기술-스택)
- [프로젝트 구조](#프로젝트-구조)
- [설치 및 실행 방법](#설치-및-실행-방법)
- [애플리케이션 설정](#애플리케이션-설정)  <!-- 링크 확인 -->
- [주요 기능](#주요-기능)
  
## 프로젝트 소개

이 프로젝트는 **Spring Boot**를 기반으로 개발되었으며, **H2 데이터베이스**를 사용하여 데이터를 저장하고, **JPA**를 통해 데이터 관리를 수행합니다. **Thymeleaf**는 서버 사이드 템플릿 엔진으로, HTML 파일과 연동되어 동적인 웹 페이지를 생성합니다.

## 기술 스택

- **Spring Boot**: 스프링 부트(Spring Boot)는 웹 프로그램(웹 애플리케이션)을 쉽고 빠르게 만들 수 있도록 도와주는 자바의 웹 프레임워크
- **H2 Database**: 임베디드 관계형 데이터베이스
- **JPA (Java Persistence API)**: 자바 애플리케이션과 관계형 데이터베이스 사이 데이터 영속성을 관리하기 위한 표준화된 인터페이스
- **Thymeleaf**: 스프링 서버에서 데이터를 받아 우리가 보는 웹 페이지, 즉 HTML 상에 그 데이터를 넣어 보여 주는 템플릿 엔진
- **IntelliJ IDEA**: 프로젝트 개발에 사용된 통합 개발 환경 (IDE)

## 프로젝트 구조

```plaintext
src
├── main
│   ├── java
│   │   └── com.mysite.sbb
│   │       ├── controller      # 웹 컨트롤러
│   │       ├── entity          # JPA 엔티티 클래스
│   │       ├── repository      # JPA 레포지토리 인터페이스
│   │       ├── service         # 서비스 클래스
│   │       └── ProjectApplication.java  # 메인 애플리케이션 클래스
│   ├── resources
│   │   ├── templates           # Thymeleaf 템플릿 파일
│   │   ├── application.properties # 애플리케이션 설정
│   │   └── data.sql            # 초기 데이터 로드 스크립트
└── test                        # 테스트 코드
```

## 설치 및 실행 방법

### 1. 사전 요구 사항
- JDK 17 이상
- Gradle
- IntelliJ IDEA

### 2. 프로젝트 클론

```bash
git clone https://github.com/yourusername/yourproject.git
cd yourproject
```

### 3. IntelliJ IDEA에서 열기

1. IntelliJ IDEA를 열고 `File -> Open...`을 선택하여 클론한 프로젝트 디렉토리를 엽니다.
2. IntelliJ IDEA 왼쪽 상단에 `File -> Setting -> Build, Execution, Deployment -> Build Tools -> Gradle`에서 `Gradle JVM`을 `Oracle OpenJDK 17`로 선택합니다.
3. 그 다음은 `Setting -> Build, Execution, Deployment -> Compiler -> Java Compiler`에서 `Project bytecode version`을 17로 선택합니다.
4. Apply를 누르면 JDK버전에 맞는 Gradle 버전으로 Gradle import됩니다.
5. Maven 또는 Gradle을 사용하여 종속성을 자동으로 다운로드하도록 설정합니다.
   

### 4. 애플리케이션 실행

1. `src/main/java/com/mysite/sbb/SbbApplication.java` 파일을 찾아 실행합니다.
2. 애플리케이션은 기본적으로 `http://localhost:5000`에서 실행됩니다.


### 5. H2 콘솔 접속

- 애플리케이션이 실행된 후, H2 콘솔은 `http://localhost:8080/h2-console`에서 확인할 수 있습니다.
- 기본 연결 정보:
  - JDBC URL: `jdbc:h2:mem:testdb`
  - 사용자명: `sa`
  - 비밀번호: 비어 있음


## 애플리케이션 설정

- 설정 파일은 `src/main/resources/application.properties`입니다.
  - **spring.application.name**: 애플리케이션 이름 지정
  - **sever.port**: 웹 접속 포트 번호를 지정
  - **spring.h2.console.enabled**: H2 데이터베이스 콘솔 활성화여부 설정
  - **spring.h2.console.path**: H2 데이터베이스 접속 URL
  - **spring.datasource.url**: H2 데이터베이스 경로
  - **spring.datasource.driverClassName**: 데이터베이스 드라이버 지정
  - **spring.datasource.username**: 데이터베이스 접속 아이디
  - **spring.datasource.password**: 데이터베이스 접속 비밀번호
  - **spring.h2.console.settings.web-allow-others**: 필수는 아니지만 외부에서 H2콘솔 접속 허용 여부


## 주요 기능

- **사용자 관리**: 사용자 생성, 조회, 수정, 삭제
- **게시글 관리**: 게시글 작성, 조회, 수정, 삭제
- **게시글 부가기능**: Markdown, 투표, 답글 작성
- **H2 데이터베이스 관리**: H2 콘솔을 통한 데이터베이스 관리
