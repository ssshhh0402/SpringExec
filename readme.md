# ReadMe

## Java Spring Frame 복습 및 연습

# TodoList

* 4월 14일
  * 기본 설정 및 사용 Dependency들 설정
    * 사용 Dependency
      * Jpa, Jpa-Web, Lombok, H2, Swagger
  * Swagger 설정

---

* 4월 15일
  * User 관련 기능 API 구현
    * 회원 가입
      * url : (Post) /api/v1/user/save
      * Request Params으로 (String) Email, (String) Password 전달
    * 로그인
      * url : (Post) /api/v1/user/login
      * Request Params으로 (String) Email, (String) Password 전달
      * Email을 통해 데이터베이스에 저장되어있는 Password 갖고온 후 입력받은 값과 동일한지 비교
      * 동일하면 HttpStatus.OK | 동일하지 않으면 HttpStatus.Not_Found
    * 비밀번호 찾기
      * url : (Get) /api/v1/user/find/{email}
      * Path variable으로 email 전달
      * email을 사용하여 데이터베이스에 저장되어 있는 Password 갖고 온후 반환



* 보완점 / 궁금한 점
  * 로그인
    * 좀 더 간단한 로직이 있을 것 같은데 없나..?
  * 비밀 번호 찾기
    * 좀 더 복잡하게 보완해야 할듯
    * 입력받은 email이 유저일 경우 / 아닐 경우 나눠야 한다
      * 프론트쪽에서 처리할 수도 있지만 백엔드 쪽에서 하는게 좋을듯하다
  * IntelliJ..?
    * compile하는데는 문제 없는 빨간줄("Variable 000000 is not initialized") 이거 어떻게 없애더라...
* 내일 할 것
  * Post 관련 기능 API 구현
    * 기본 CRUD
    * 특정유저 생성 목록 보기
    * 완료 목록 / 미완료 목록 보기
    * 일단 여기까지?

----



* 4월 16일
  * Post 관련 기능 API 구현
    * Post 생성
      * Url : (Post)/api/v1/post/
      * RequestParams로 이메일, Contents, isDone(boolean)
    * Post 삭제
      * Url : (Delete) /api/v1/post/delete/{id}
      * PathVariable로 postId 전달받아 해당 Post 삭제
    * Post 변경
      * Url : (Post) /api/v1/post/update
      * RequestParams로 id, 이메일, Contents, isDone을 받아 id값과 동일한 Post를 전달받은 내용으로 변경
    * Post 불러오기
      * 모든 포스트 불러오기
        * Url : (Get) /api/v1/post/
        * 현재 저장되어 있는 모든 포스트 출력
      * 특정 유저가 작성한 포스트 불러오기
        * Url : (Get) /api/v1/post/{email}
        * Path Variable로 받은 이메일이 작성한 포스트 출력
      * 특정 유저가 작성한 포스트의 상태에 따라 출력
        * Url : (Get) /api/v1/post/{email}/{isDone}
        * Path Variable로 이메일과 isDone(boolean)을 받아 일치하는 포스트 출력
* 보완점 / 궁금한 점
  * Post 관련 Swagger에서 확인했을 때 User와 다른 것이 있는데 왜 다른지..? Id와 Post Id 왜 둘다 나오는지 확인해보고 수정해야한다
* 다음에 할 것
  * Real Db(연동)

---

* 4월 26일

  * Mysql 및 mysql-workbench 설치

  * JPA와 Db(Mysql) 연동 완료

    * build.gradle에 dependency 추가

    ~~~Java
    ...	
    compile('mysql:mysql-connector-java')
    ~~~

    

    * properties 설정

    ~~~Java
    spring.jpa.show-sql=true
    spring.jpa.generate-ddl=true
    spring.jpa.database=mysql
    spring.datasource.url=jdbc:mysql://localhost:3306/todo?autoReconnect=true&useSSL=true&serverTimezone=Asia/Seoul
    spring.datasource.username=**
    spring.datasource.password=**
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
    
    ~~~

    * Generate-ddl : true => 테이블이 존재하지않을경우 자동으로 생성
    * show-sql : true => sql  명령어들을 Log로 볼수 있게 설정함
    * datasource.username & password : database 유저이름과 비밀번호

* 보완점 && 해야할 것:

  * 직접 연결해서 넣어보니 수정해야할게 많다... 일단 한번 수정하고 가야할듯
  * 일단 Post email(글쓴이) 와 User가 Foreign Key로 연결 안 돼어있다
  * 이거말고 Database 좀더 견고하게 수정해야할듯

  

---

* 4월 28일
  * DB 수정
  * Api 관련 스웨거에서 응답이 이상하게 오던거 수정
    * => Entity와 dto 나눠서 구현
    * Entity를 dto로 사용할 경우 이 같은 문제가 발생할 수 있다.
* 보완점 && 해결할 것
  * 아니 Primary Key 왜 안돼지?
  * Foreign Key 연결

---

* 5월 2일

  * DB 수정 완료
    * Primary Key 안되던거 => 테이블 문제였는듯 테이블 다 삭제하고 다시 생성하니 적용됨
    * Foreign Key 연결 => 성공
      * 그... 변수명이랑 사용하는 인자명? 동일하게 해야 한다는 거 주의해야할듯
      * 뭐냐 그 근데 Cascade 제대로 안된게 살짝 불안하다 제대로 된건지 모르겠다

* 추가할 기능

  * Post 댓글 기능 추가해야겠다
  * 댓글 ,대댓글

  

---

* 5월 4일

  * Post 댓글 기능 추가(완)
  * User 비밀번호 암호화 적용
    * Spring-boot-starter-security 활용
    * sha-256이랑 이거랑 다른 느낌인가? 이건 따로 공부해봐야할듯

* 추가할 것

  * 대댓글(계층형 구조) 구현해야한다

  

---

* 5월 20일

  * 대 댓글(계층형 구조) 구현 완료
  * 다만 코드가 뭔가 맘에 안든다...
  * 이거 재귀가 너무 많음 수정할 방법을 한번 찾아봐야할듯
  * Java EmailSender 활용
    * 비밀 번호 찾기에 사용

* 추가 할 것

  * 회원가입할 때 이메일 인증 기능 만들어야할듯




---

* 7월 26일

  * Session 적용 완료
  * Login시 이메일 저장하도록 구현
  * 추가적으로 저장한 이메일을 활용할 부분 구현해 놔야할듯

* 추가 할 것

  * 다른 사람들 코드 보니 백엔드에서 반환 값으로 연결될 주소? 주는 경우가 많은듯
  * 그런 식으로 구현해 보는 것도 나쁘지 않을 것 같습니다

  

---

* 7월 27일

  * 세션 사용 관련 기능 수정
    * Logout, getPost

* 궁금 한 것

  * Session...이 없을때 UnAthorized가 맞나 Method Not Allowed가 맞나..
  * 또 추가적으로 로그인이 필요한 부분이 어딜까..

* 추가 해야 할 것

  * 역활 추가해야 할듯(관리자, 일반 유저)
  * 역활에 따른 기능 구분해야 할듯

  

# 실시간 채팅 

* 5월 26일

  * 기본적인 기능들 구현완료
    * 생성되어 있는 채팅방에 대하여 참가 기능
    * 채팅방내에서 채팅 기능
    * WebSocket 기능 활용
  * 이를 활용하여 추가적인 기능구현해야겠다
    * 로그인, 채팅방 개설, 채팅방 삭제

  

* 5월 28일
  * 실시간 채팅 기능 웹서비스를 위한 기본기능 구현 
  * 로그인, 채팅방 개설기능
* 구현해야 할것
  * 참가 기능, 채팅기능
  * redis활용하면 채팅 저장기능?이 될거같은데..





# 동적 Crawler

* 목표 : Java Selenium 활용해서 네이버 자동 로그인 후 읽지않은 메일이 존재할 경우 해당 사실을 카카오톡으로 메세지를 날려 알려주는 기능 구현하기

* 핵심 기술 :

  * Java Selenium
  * Kakao Api

* Selenium vs Jsoup?

  * 둘다 Crawling 하는 방법이라면 왜 굳이 Selenium이 필요한가?
  * Selenium과 Jsoup의 차이점은 동적 / 정적 Crawling
  * Jsoup은 정적 Crawling으로써 나에게 보여지는(내가 주어준) 화면에서의 데이터만 Crawling 가능
  * Selenium은 동적 Crawling으로써 Crawling외에도 클릭등의 행위를 통해 내가 원하는 화면으로 이동이 가능하다
  * 이러한 Selenium의 특징을 활용해서 웹 페이지 테스트 용도로도 많이 사용하는 것 같다.

* 7 / 30

  * 1차 구현
    * Api를 통해 아이디와 비밀 번호 입력
    * 해당 정보를 통하여 로그인을 진행하고자 시도
    * Selenium의 send_keys 메소드를 핵심으로 사용
    * 하지만 이렇게 했을 경우, 네이버의 자동 완성 매크로(왓챠)에 걸린다

  * 2차 구현

    * Api를 통해 받는것 까지는 동일
    * 구글링을 해본 결과 파이썬에서는 Paperpy를 사용하여 입력하고자 하는 값을 Clipboard에 저장하고, 이것을 Control + V, 즉 붙여넣기로 넣는다는것을 확인
    * 자바 Toolkit 라이브러리를 활용하여 유사하게 진행
    * Clipboard에 저장하는것 까지는 구현

  * 수정해야 할 부분

    * Clipboard를 붙여넣기 하는 과정에 있어 Command + V 누르는 Action을 구현해야 한다.(난 맥북이니까)
    * 현재 생기는 문제로써는 V를 Action에서 어떻게 찾을 것인가

    

