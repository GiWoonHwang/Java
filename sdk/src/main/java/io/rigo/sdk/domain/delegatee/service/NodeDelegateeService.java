package io.rigo.sdk.domain.delegatee.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.delegatee.model.Delegatee;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeDelegateeService {
    @GET("/delegatee")
    Call<NodeApiResponse<Delegatee>> queryDelegatee(@Query("addr") String address);
}
