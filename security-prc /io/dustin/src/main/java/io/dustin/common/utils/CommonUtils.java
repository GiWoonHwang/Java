package io.dustin.common.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

    private static ObjectMapper objectMapper = null;

    private static ObjectMapper mapper() {
        if(objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        }
        return objectMapper;
    }

    /**
     * 객체를 json string으로 변환한다.
     * @param object
     * @return String
     * @throws RuntimeException
     */
    public static String toJson(Object object) {
        String result;
        try {
            result = mapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    /**
     * json String을 넘겨받은 객체 class타입으로 변환한다.
     *
     * @param content
     * @param clazz
     * @return T
     * @throws RuntimeException
     */
    public static <T> T convertObject(String content, Class<T> clazz) {
        T object;
        try {
            object = mapper().readValue(content, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return object;
    }

}
