package io.dustin.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
DataNotFoundException이 발생하면 @ResponseStatus 애너테이션에 의해 404 오류(HttpStatus.NOT_FOUND)가 나타날 것이다.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException{
    /*
    Class는 UID를 가지고 있는데 Class의 내용이 변경되면 UID값 역시 같이 바뀌어 버립니다. 직렬화하여 통신하고 UID값으로 통신한게 정상인지 확인하는데 그 값이 바뀌게 되면 다른 Class로 인식을 해버리게 됩니다.
    이를 방지하기 위해 고유값으로 미리 명시를 해주는 부분이 바로 "private static final long serialVersionUID"
     */
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message){
        super(message); // super는 부모 클래스를 호출하는 거라는 데..
    }
}
