package io.sdk;

import retrofit2.Call;
import retrofit2.http.GET;
public interface TestService {
    @GET("/abci_info?")
    Call<Object> getTest();
}
