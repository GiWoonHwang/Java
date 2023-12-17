package io.dustin.board.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(
        basePackages = {
                "io.dustin.board.*"
        }
)
@EnableJpaRepositories(
        basePackages = {
                "io.dustin.board.*"
        }
)
@EntityScan(
        basePackages = {
                "io.dustin.board.*"
        }
)
public class BoardDomainConfiguration {
}
