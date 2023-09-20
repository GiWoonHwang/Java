package io.dustin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DustinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DustinApplication.class, args);
	}

}
