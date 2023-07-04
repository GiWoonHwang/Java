package io.rigo.sdk.common.client.factory;

import io.rigo.sdk.common.client.RigoApiRestClientImpl;
import io.rigo.sdk.common.client.RigoWeb3;

/**
 * node와 통신하는 ClientFactory
 * created by basquiat
 */
public class RigoApiClientFactory {
    private String baseUrl;

    private RigoApiClientFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static RigoApiClientFactory newInstance(String baseUrl) {
        return new RigoApiClientFactory(baseUrl);
    }

    public RigoWeb3 rigoWeb3() {
        return new RigoApiRestClientImpl(baseUrl);
    }
}
