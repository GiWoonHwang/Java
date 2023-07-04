package io.rigo.sdk.domain.validator.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.validator.model.Validator;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeValidatorService {
    @GET("/validators")
    Call<NodeApiResponse<Validator>> queryValidators(@Query("height") long height);
}
