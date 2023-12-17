package io.dustin.common.utils;

import io.dustin.common.provider.ApplicationContextProvider;
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

}
