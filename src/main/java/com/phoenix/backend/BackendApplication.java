package com.phoenix.backend;

import com.phoenix.backend.auth.AuthRepository;
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

    @Bean
    public CommandLineRunner demo(AuthRepository repository) {
        return (args) -> {
            log.info("Logs de la aplicacion");
//            log.info(repository.sp_print_hello_world_estadiadvt("java"));
            if (repository.sp_get_auths_verify_user_estadiadvt("username", "password")) {
                log.info("El usuario esta registrado en la base");
            } else {
                log.info("El NO esta registrado en la base");
            }
        };
    }
}
