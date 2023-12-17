package io.dustin.apps.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dustin.apps.common.provider.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public static <T> T getBean(String beanId, Class<T> clazz) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if(applicationContext == null) {
            throw new NullPointerException("Not Initialize Spring Container!");
        }
        return (T)applicationContext.getBean(beanId);
    }

    public static String toJson(Object value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }

}
