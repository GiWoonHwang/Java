package io.rigo.sdk.domain.rule.service;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.rule.model.Rule;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NodeRuleService {
    @GET("/rule")
    Call<NodeApiResponse<Rule>> queryRule();

}
