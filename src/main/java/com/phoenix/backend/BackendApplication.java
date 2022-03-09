package com.phoenix.backend;

import com.phoenix.backend.auth.login.repository.AuthRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);
    private AuthRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
