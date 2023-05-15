package com.mysite.sbb;

import com.mysite.sbb.common.config.RigoWeb3Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 애너테이션을 통해 모든 스트링부트의 설정이 관리된다.
public class SbbApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SbbApplication.class, args);
//		RigoWeb3Configuration test = new RigoWeb3Configuration();
//		System.out.println(test.rigoClient());
	}

}
