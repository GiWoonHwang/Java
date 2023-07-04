package io.rigo.sdk.domain.transaction.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.transaction.model.Transaction;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeTransactionService {
    @GET("/tx")
    Call<NodeApiResponse<Transaction>> queryTrx(@Query("hash") String txHash);
}
