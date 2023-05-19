# Java SDK for RIGO

`rigo-sdk-java` is Javascript SDK for RIGO blockhcain network.

## Prerequisite

java version: higher open jdk 11
gradle version: higher 7.4

## deploy

see build.gradle

```shell
$> ./gradlew publishToMavenLocal

## or

$> gradlew publishToMavenLocal
```

you can use IDE Plugin,

```shell
Click rigo-skd-java > Tasks > publishing > publishToMavenLocal
```

## usage

if you use gradle,

```groovy
plugins {
	id 'java'
}
repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation 'io.rigo:sdk:0.0.1-SNAPSHOT'
}

tasks.named('test') {
	useJUnitPlatform()
}
```

if you use maven

```xml
<dependency>
    <groupId>io.rigo</groupId>
    <artifactId>sdk</artifactId>
    <optional>0.0.1-SNAPSHOT</optional>
</dependency>
```

## This Repository is Experimental API

This repository is currently under development.

So, currently you can use `Account`, `Transaction` API.

## How to use On Spring Framework

if you use this sdk,

see below

```java
package io.rigo.scan.common.configuration;

import io.rigo.sdk.common.client.RigoWeb3;
import io.rigo.sdk.common.client.factory.RigoApiClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RigoConfiguration {

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

```

then your service

```java
package io.rigo.scan.domain.account.service;

import io.rigo.sdk.common.client.RigoWeb3;
import io.rigo.sdk.domain.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final RigoWeb3 rigoWeb3;

    public Account queryAccount(String address) {
        return rigoWeb3.queryAccount(address);
    }
}
```

## Subscriber Usage
this skd provider node Subscriber.

if you spring framework, see below.

```java
@Component
public class SubscriberListener {

    @Value("${rigo.node.socket}")
    private String websocketUrl;

    @EventListener(ApplicationReadyEvent.class)
    public void newBlockSubscribe() throws InterruptedException {
        Subscriber subscriber = new Subscriber(websocketUrl);
        SubscriberCallback callback = (message) -> {
            System.out.println(message);
        };
        subscriber.start(DefaultEventType.NEW_BLOCK, callback);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void txSubscribe() throws InterruptedException {
        Subscriber subscriber = new Subscriber(websocketUrl);
        SubscriberCallback callback = (message) -> {
            System.out.println(message);
        };
        subscriber.start(DefaultEventType.TX, callback);
    }

}
```
this sdk provider `SubscriberCallback` interface

## for Development

this project use gRPC.

so if you develop this project, must build project first

and gRPC code gen. you can see build directory

```
build > generated > source > proto > main > io.riog.sdk.proto > TrxPb class
```
