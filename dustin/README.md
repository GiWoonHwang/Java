```
도메인에서 dto를 반환하지 마라
도메인은 순수해야 한다(오염시키지 마라)


--- io.dustin
    
    ㄴ apps
       ㄴ common
          ㄴ config 
          ㄴ utils
          ㄴ handler
          ㄴ exception
          ㄴ listener
          ㄴ convertor
          ㄴ repository
          ㄴ code
          ㄴ annotations
          ㄴ aop
          ㄴ interceptor
       ㄴ board
          ㄴ API
            ㄴ controller
            ㄴ usercase
               ㄴ 비지니스 로직을 짠다.
       
          ㄴ dmoain -> data 정보를 엔티티로 순수하게 반환하는 API
            ㄴ member
              ㄴ model
                 ㄴ dto
                 ㄴ entity
                 ㄴ code -> bsgp
              ㄴ service
              ㄴ repository   
            ㄴ notice
            ㄴ faq 
            ㄴ qna
              ㄴ service
                  ㄴ di memberServer-> memberid -> member select
       ㄴ blockchain
       .
       .
       .
       .
       .   
       ㄴ SbbApication.class
   
    ㄴ external

유저
 - 회원가입 (구글, 카카오, 네이버, 깃)
 - 로그인 (jwt)
 - 로그아웃
 - 비밀번호 변경
 - 비밀번호 찾기
 - 닉네임 변경
 - 계정 비활성화
 - 계정 탈퇴

커뮤니티 사이트
 - 게시물 작성(사진, 동영상)
 - 댓글 및 대댓글 작성 (jpa? query?)
 - 좋아요(추천)
 - 즐겨찾기(북마크)
 - 게시물, 댓글 삭제
 - 신고(게시물, 댓글)
 - 유저 등급제도
 - 검색기능(조건부 검색 가능)
 
qna
 - 공통질문 작성
 - 1:1 문의
 - 1:1 답변

공지
 - 공지사항 작성
 - 공지사항 저장
 - 공지사항 보여주기
 
어드민
 - 신고 처리
 - 광고 (올리기, 변경)
 - 유저 강등
 - 유저 정지
 - qna 관리
 - 게시판 관리(디시 인사이드 같이)
 
 

 












작업해야 할일 
- 좋아요 ,북마크 등등 .. 프론트 입장에서 표시하려면 어떻게 해야하나 ? (인터페이스 이용)
- 로그인, 회원가입 기능
- 어드민에는 무엇을 넣을것인가














```