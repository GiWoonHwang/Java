package dustin.libs.common.utils;

import dustin.libs.common.exception.DataNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalUtils {


    public static <T> T getEntity(Optional<T> optional, Class<T> clazz, String errorMessage) {
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException(errorMessage);
        }
    }

}
