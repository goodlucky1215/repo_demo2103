# repo_demo2103
스프링 부트와 리액트 개발 환경 포함 설정 완결본
spring boot 2.4.0
- spring Boot DevTools
- spring web<br>
  jdk1.8


- pom.xml 의존성 주입과 관련, maven repo를 수정하면 동기화가 일어남 .

       ⇒ 즉, pom.xml에 작성하면 maven Dependencies에 추가가 됨.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
1. groupId : 다른 컴포넌트와 라이브러리와 차별될 수 있는 유니크한 명칭 - 보통 프로젝트를 생성한 그룹명
2. artifactId : 해당 프로젝트 명칭(컴포넌트 명칭), groupId 범위 내에서 유일해야 함.
3. version : 해당 컴포넌트의 version
4. parent : pom.xml은 상속을 받을 수 있다. <parent> pom.xml은 자주 사용하는 라이브러리들의 버전
						정보나 dependency들을 이미 가지고 있어서 참조하기 편리하다.
5. relativePath : parent 폴더의 경로
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
6. package : jar, war, ear, pom등 패키지 유형을 나타낸다. -> 우리가 만들때 이렇게 설정함.
7. name : 프로젝트 이름
8. description : 프로젝트 설명
	<groupId>com.example</groupId>
	<artifactId>demo2103_1</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>demo2103_1</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>

9. dependencies : 의존성 라이브러리 정보
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

10. scope : dependency의 영역같은 것(해당 라이브러리가 적용될 범위 지정)
						설정을 안하면 default는 complie
            *runtime은 컴파일할 때 필요하지 않지만 실행 할 때 필요 (예-jdbc)
						*provided : compile과 유사하나 jdk 또는 컨테이너가 런타임 시에만 해당 라이브러리 제공
												컴파일이나 테스트 경로에만 쓰일 뿐, 배포 시 빠짐.
11. optional : 이 프로젝트가 다른 프로젝트에 의존성을 가진 경우 사용할지 여부를 선택
	* 만약 A프로젝트가 B프로젝트의 라이브러리를 참조하여 사용한다고 한다.
    B프로젝트에서 true로 넣어뒀다면, A는 B의 해당 라이브러리를 참조 할 수 없다.
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>

**얘는 개인적으로 중요!
1. 만약 다음과 같은 문제가 발생한다면?
jsp가 실행이 되야하는데 **다운로드** 되고 있다. -> jsp에대한 mine-type이 처리가 안되고 있다는 거임 
2. 해결?
실행되게하려면 이 부분을 꼭 넣어줘야함!!
3. 왜 실행이 안되고, 다운로드만 일어날까?
jsp컨테이너와 servlet컨테이너를 못 찾을 때 다운로드가 일어남.
톰캣이 jsp컨테이너와 servlet컨테이너 역할을 하는데, 이 부분의 톰캣이 없으니 당연히 찾을 수 없겠지?
--------dlrj
  <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
      <scope>provided</scope>
  </dependency>

12. bulid(필수사항) : 빌드할 때 사용할 플러그인 목록을 기록
13. plugin : 프로젝트 빌드 과정 중에서 실제로 무언가를 하기 위해 설정하는 jar파일
테스트를 위해 A가 필요한 경우 plugin안에 넣으면, 테스트 전에 A를 실행한다. 테스트가 끝나면 A도 종료
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```
