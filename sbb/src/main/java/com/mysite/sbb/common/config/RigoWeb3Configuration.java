package com.mysite.sbb.common.config;

import io.rigo.sdk.common.client.RigoWeb3;
import io.rigo.sdk.common.client.factory.RigoApiClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RigoWeb3Configuration {

    @Value("${rigo.node.url}")
    private String baseUrl;

    @Bean
    public RigoWeb3 rigoClient() {
        RigoApiClientFactory factory = RigoApiClientFactory.newInstance(baseUrl);
        return factory.rigoWeb3();
    }

    // TODO Subscriber
    //public Subscriber rigoSubscriber() {
    // TODO
    //}
}
