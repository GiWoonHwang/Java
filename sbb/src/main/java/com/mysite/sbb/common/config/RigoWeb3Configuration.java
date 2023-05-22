package com.mysite.sbb.common.config;

import io.rigo.sdk.common.client.RigoWeb3;
import io.rigo.sdk.common.client.factory.RigoApiClientFactory;
import io.rigo.sdk.subscriber.Subscriber;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
