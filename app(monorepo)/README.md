```
--- io.dustin


프로젝트 구조
 ㄴ apps
    ㄴ domain
        ㄴ common     
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
        
    ㄴ project
        ㄴ api
            ㄴ controller
                - DomainController.java
            ㄴ usecase
                - ReadDomainUseCase.java
                - WriteDomainUseCase.java
                - DeleteDomainUseCase.java
                - ModifyDomainUseCase.java 
        ㄴ SpringBootApplication.java
        
    

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



--- 06.28일 ---

1. 어드민은 기본적으로 도메인의 usecase를 다시 불러온다 -> ex) 게시물 리스트 등등 ... 
 -> 그렇다면 usecase를 가져다 써야 하나 ? usecase는 요구사항을 구현해 놓은거니까 service를 써야 하나 ?
 
2. 광고를 올려야 하니까 게시물 작성도 필요하겠고 ...

3. 1번 고민은 잘못 되었다. 어드민은 개별 프로젝트로 분리한다


--- 07.04 ---

1. 06.28의 고민의 결과로 어드민을 개별 서버에서 실행킨다. 이에 더해   프로젝트를 모노레포로 구성하기로 결정

모노레포 사용 이유
    - 코드 공유 및 재사용: 모노레포에서는 여러 프로젝트가 동일한 코드베이스를 공유할 수 있다. 공통 모듈, 유틸리티, 컴포넌트 등을 단일 저장소에서 관리하므로 코드 중복을 피하고, 코드 품질과 일관성을 유지할 수 있다.
    - 의존성 관리: 모노레포에서는 프로젝트 간의 의존성을 쉽게 관리할 수 있다. 의존하는 프로젝트의 코드 변경이 있을 때 자동으로 의존하는 프로젝트도 업데이트되므로 일관된 버전 관리가 가능하다.
    - 협업 및 커뮤니케이션 간소화: 모노레포에서는 여러 프로젝트가 함께 개발되므로, 팀 내에서의 협업과 커뮤니케이션이 용하다. 코드 변경에 대한 지식 공유와 코드 리뷰, 버그 추적 등이 단일 저장소에서 이루어지므로 효율성을 높일 수 있다.
    - 버전 관리 및 이력 추적: 모노레포에서는 모든 프로젝트의 버전 관리 및 이력 추적을 단일 저장소에서 수행할 수 있다. 이를 통해 특정 시점의 코드 상태를 쉽게 확인하고, 변경 내역을 추적하고 관리할 수 있다. 
```