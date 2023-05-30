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

```