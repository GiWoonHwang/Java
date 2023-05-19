package io.rigo.sdk.common.client;

import io.rigo.sdk.common.exception.RigoApiException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RigoApiServiceGenerator {

    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder();

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);
        builder.baseUrl(baseUrl);
        builder.client(httpClient.build());
        builder.addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RigoApiException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new RigoApiException(e.getMessage());
        }
    }
}
