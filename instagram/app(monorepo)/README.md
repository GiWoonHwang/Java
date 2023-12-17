```
--- io.dustin

기존 프로젝트를 모노레포로 변경

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
