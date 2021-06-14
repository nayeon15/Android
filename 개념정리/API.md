#### REST란?

+ 자원을 이름으로 구분하여 해당 자원의 정보(상태)를 주고 받는 모든 것을 의미한다.

+ 자원의 표현

  + 자원: 해당 소프트웨어가 관리하는 모든 것

  ex) 문서, 그림, 데이터, 해당 소프트웨어 자체 등

  + 자원의 표현: 그 자원을 표현하기 위한 이름

  ex) DB의 학생 정보가 자원일 때, 'student'를 자원의 표현으로 정한다.

+ 상태(정보)전달

  + 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달한다.
  + json 혹은 xml를 통해 데이터를 주고 받는 것이 일반적이다.

+ rest는 네트워크 상에서 클라이언트와 서버 사이의 통신 방식 중 하나이다.

+ __rest의 구체적인 개념__

  + HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.
  + CRUD Operation
    Create : 생성(POST)
    Read : 조회(GET)
    Update : 수정(PUT)
    Delete : 삭제(DELETE)
    HEAD: header 정보 조회(HEAD)

------------

### REST API

+ API: 데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환 가능하도록 하는 것
+ REST API의 정의
  + REST 기반으로 서비스 API를 구현하는 것
  + 최근 openAPI , 마이크로 서비스 등을 제공하는 업체 대부분은 REST API를 제공한다.
+ 특징
  + 사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운영을 편리하게 할 수 있다.
  + REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지운하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있다.
  + REST API를 제작하면 델파이 클라이언트 뿐 아니라 자바, C#, 웹 등을 이용해 클라이언트
+ REST API 설계 예시

![img](https://gmlwjd9405.github.io/images/network/restapi-example.png)


