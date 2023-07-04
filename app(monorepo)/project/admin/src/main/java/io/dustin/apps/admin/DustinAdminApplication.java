package io.dustin.apps.admin;

import io.dustin.admin.common.annotations.EnableAdminDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAdminDomain
public class DustinAdminApplication {
    public static void main(String[] args)  {
        SpringApplication.run(DustinAdminApplication.class, args);
    }
}
