package com.nix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nix.dao")
public class CinemaTicketSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaTicketSystemApplication.class, args);
    }
}
