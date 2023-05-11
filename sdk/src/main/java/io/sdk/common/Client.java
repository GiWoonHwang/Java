package io.sdk.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.sdk.service.Blocks;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
        /*
        앞서 구현한 getInstance를 이용해 클라이언트를 생성한 뒤, 클라이언트를 이용하여
        Http API 명세가 담긴 Interface의 구현체를 생성한 뒤 반환한다.
         */

public class Client {
    private static final String BASE_URL = "http://192.168.252.60:26657/";
    public static Blocks getBlockService() {
        return getInstance().create(Blocks.class);
    }

    private static Retrofit getInstance() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
