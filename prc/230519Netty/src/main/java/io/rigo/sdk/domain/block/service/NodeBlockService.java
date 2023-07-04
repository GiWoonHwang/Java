package io.rigo.sdk.domain.block.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.block.model.Block;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeBlockService {
    @GET("/block")
    Call<NodeApiResponse<Block>> queryBlockByHeight(@Query("height") Integer height);

    @GET("/block")
    Call<NodeApiResponse<Block>> queryBlockByHash(@Query("hash") String hash);




}
