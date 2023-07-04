package io.rigo.sdk.common.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.rigo.sdk.subscriber.model.response.ResponseResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {

    public static <T> ResponseResult<T> subscribeMessageFromJson(String contents, Class<T> clazz) {
        Gson gson = new Gson();
        Type responseType = new TypeToken<ResponseResult<T>>() {}.getType();
        return gson.fromJson(contents, responseType);
    }

    public static <T> T fromJson(String contents, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(contents, clazz);
    }

    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                                     .create();
        return gson.toJson(object);
    }

}