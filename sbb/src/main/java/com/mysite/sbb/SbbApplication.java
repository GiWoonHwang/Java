package com.mysite.sbb;

import com.mysite.sbb.common.config.RigoWeb3Configuration;
//import com.mysite.sbb.subscriber.SubscriberListener;
import io.rigo.sdk.subscriber.Subscriber;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 애너테이션을 통해 모든 스트링부트의 설정이 관리된다.
public class SbbApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SbbApplication.class, args);
//		RigoWeb3Configuration test = new RigoWeb3Configuration();
//		System.out.println(test.rigoClient());

//		Subscriber subscriber = new Subscriber("ws://192.168.252.60:26657/websocket");
//		SubscriberCallback callback = (message) -> {
//			System.out.println(message);
//		};
//		subscriber.start(DefaultEventType.NEW_BLOCK, callback);


	}

}
