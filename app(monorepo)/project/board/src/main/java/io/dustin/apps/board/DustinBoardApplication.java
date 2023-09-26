package io.dustin.apps.board;

import io.dustin.board.common.annotations.EnableBoardDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableBoardDomain
public class DustinBoardApplication {
    public static void main(String[] args)  {
        SpringApplication.run(DustinBoardApplication.class, args);
    }
}



