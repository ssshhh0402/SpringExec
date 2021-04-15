# ReadMe

## Java Spring Frame 복습 및 연습

### 1)TodoList

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



