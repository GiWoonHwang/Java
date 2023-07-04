package io.rigo.sdk.domain.account.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.account.model.Account;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeAccountService {
    @GET("/account")
    Call<NodeApiResponse<Account>> queryAccount(@Query("addr") String address);
}
