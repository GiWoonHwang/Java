```
--- io.dustin

프로젝트 구조
 ㄴ apps
    ㄴ domain
        ㄴ api
            ㄴ controller
                - DomainController.java
            ㄴ usecase
                - ReadDomainUseCase.java
                - WriteDomainUseCase.java
                - DeleteDomainUseCase.java
                - ModifyDomainUseCase.java                
        ㄴ model
            ㄴ dto
                - DomainDto.java
            - DomainEntity.java    
        ㄴ repository
            ㄴ custom
                - CustomDomainRepository.java
            - DomainRepository.java
        ㄴ service 
            - ReadDomainService.java
            - WriteDomainService.java
    ㄴ common
        ㄴ advice
        ㄴ code
        ㄴ config
        ㄴ exception
        ㄴ model
        ㄴ properties
        ㄴ provider
        ㄴ repository
        ㄴ utils
        ㄴ validation 
        
    

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

공지 ---> 어드민의 세부기능으로 이동
 - 공지사항 작성
 - 공지사항 저장
 - 공지사항 수정
 - 공지사항 보여주기
 
어드민
 - 신고 처리
 - 광고 (올리기, 변경)
 - 유저 정지
 - qna 관리
 - 공지 
 

--- 기본 기능 ---

게시물 작성 o
게시물 수정 o
게시물 삭제 o
게시물 조회(all) o
게시물 상세조회(단일) o

댓글 작성 o 
댓글 수정 o
댓글 삭제 o
댓글 조회(all) o
대댓글 조회 o

공지 작성 o
공지 수정 o
공지 삭제 o
공지 조회(all) o
공지 상세조회(단일) o

질문 작성 o
질문 수정 o
질문 삭제 o
질문 조회(all) o
질문 상세조회(단일) o

답변 작성 o
답변 수정 o
답변 삭제 o

좋아요 o
좋아요 취소 o

북마크 o
북마크 취소 o

팔로우 o
팔로우 취소 o

--- 세부 기능 ---



게시물 리스트 받아서 좋아요랑 , 북마크 유무 보여주기 o



--- 06.24 ~ 25 발생한 오류 ---


댓글없는 게시물 상세조회 안됨 -> 분기처리로 해결 but 게시물 true flase가 나오지 않으므로 쿼리 두번 날려야 하는 상황 발생 ?
게시물 상세조회시 count 부분 계속 null로 표시됨 -> dto 추가로 해결
NOTICE 좋아요 안됨  -> db 설정 변경 후 해결


코드 컨벤션 ?
1. 유저아이디, 테이블id값, 제목, 내용 순으로 
2. 연관관게라면 상위테이블 id값 먼저 ex) postingId, commentId .. 
2. id -> 테이브Id ex) noticeId, questionId ...



--- 06.28일 고민 ---

1. 어드민은 기본적으로 도메인의 usecase를 다시 불러온다 -> ex) 게시물 리스트 등등 ... 
 -> 그렇다면 usecase를 가져다 써야 하나 ? usecase는 요구사항을 구현해 놓은거니까 service를 써야 하나 ?
 -> 내생각에는 서비스다: 요구사항에는 여러 기능들이 섞여있을 수 있기 떄문
 
2. 광고를 올려야 하니까 게시물 작성도 필요하겠고 ...

3. 1번 고민은 잘못 되었다. 어드민은 개별 프로젝트로 분리한다




```