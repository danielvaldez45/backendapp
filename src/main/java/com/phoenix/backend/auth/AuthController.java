package com.phoenix.backend.auth;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthRepository repository;
    

    public AuthController(AuthRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/login")
    boolean Login() {
        return true;
    }

    @PostMapping("/login")
    boolean Login(@RequestBody UserAuth userAuth) {
        //Invicar el stored procedure.
        //repository.getAllUsers();
        repository.sp_print_hello_world_estadiadvt("Java");
        return true;
    }
}
