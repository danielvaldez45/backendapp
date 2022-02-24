package com.phoenix.backend.auth;

import java.util.Collection;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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
        //Recuperamos los parametros de la peticion.
        String username = userAuth.getUsername();
        String password = userAuth.getPassword();
        
        boolean isExistsUser;
        isExistsUser = repository.sp_get_auths_verify_user_estadiadvt(username, password);
        
        ResponseHandler res = new ResponseHandler();
        
        if (isExistsUser) {
            return true;
            //return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, true);
        }
        return false;
    }
}
