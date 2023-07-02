package io.dustin.admin.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(
        basePackages = {
                "io.dustin.admin.*"
        }
)
@EnableJpaRepositories(
        basePackages = {
                "io.dustin.admin.*"
        }
)
@EntityScan(
        basePackages = {
                "io.dustin.admin.*"
        }
)
public class AdminDomainConfiguration {
}
