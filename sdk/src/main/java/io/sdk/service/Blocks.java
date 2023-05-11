package io.sdk.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Blocks {
    @GET("/block")
    Call<Object> getBlockByHeight(@Query("height") int height);

    @GET("/block_by_hash?hash=")
    Call<Object> getBlockByHash(String hash);


}
