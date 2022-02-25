package com.phoenix.backend.auth;

import java.util.Collection;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping(value = "/login", produces = "application/json")
    ResponseEntity<Object> Login(@RequestBody UserAuth userAuth) {
        System.out.println(userAuth.toString());
        //Recuperamos los parametros de la peticion.
        String username = userAuth.getUsername();
        String password = userAuth.getPassword();

        //Ejecutamos el stored procedured
        boolean isExistsUser;
        isExistsUser = repository.sp_get_auths_verify_user_estadiadvt(username, password);

        ResponseHandler response = new ResponseHandler();
        if (isExistsUser) {
            return response.generateResponse("Peticion exitosa: ", HttpStatus.OK, userAuth);
        }
        return response.generateResponse("El usuario no existe en la base de datos: ", HttpStatus.I_AM_A_TEAPOT, userAuth);
    }
}
