package io.sdk.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Transactions {
    @GET("/abci_info?")
    Call<Object> getTransations();
}
