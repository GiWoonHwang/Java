package io.rigo.sdk.domain.stake.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.stake.model.Stake;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeStakeService {
    @GET("/stakes")
    Call<NodeApiResponse<Stake>> queryStakes(@Query("addr") String address);
}
