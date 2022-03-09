package com.phoenix.backend.auth.login.controller;

import com.phoenix.backend.auth.login.model.Request;
import com.phoenix.backend.auth.login.model.Response;
import com.phoenix.backend.auth.login.repository.AuthRepository;

import com.phoenix.backend.auth.login.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/login", consumes="application/json" ,produces = "application/json")
    @ResponseBody
    ResponseEntity Login(@RequestBody Request requestLogin) {

        String username;
        String password;

        //Recuperamos los parametros de la peticion.
        username = requestLogin.getUsername();
        password = requestLogin.getPassword();

        //Creamos un objeto de tipo usuario.
        User user = new User(username, password);
        
        //Asignamos una bandera y ejecutamos el Stored Procedured.
        boolean isExistsUser;
        //Refactorizar esto y renombrarlo como un metodo
        isExistsUser = repository.sp_get_auths_verify_user_estadiadvt(username, password);

        if (isExistsUser) {    
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Response(100, "Peticion exitosa", user));

        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(102, "Algo fallo en el servidor", user));
    }

    //<editor-fold defaultstate="collapsed" desc="register function">
    /*@PostMapping(value = "/register", produces = "application/json")
    ResponseEntity<Object> register(@RequestBody UserAuth registerUser) {
        boolean isRegister = true;
        String username;
        String email;
        String password;

        //Recuperamos los parametros de la peticion.
        username = registerUser.getUsername();
        email = registerUser.getEmail();
        password = registerUser.getPassword();

        //Asignamos una bandera y ejecutamos el Stored Procedured.
        //Valida las credenciales mediante snippets hardcode. Si es true significa que no esta registrado
        if (!username.equals("daniel210")) {
            isRegister = false;
        }

        //isExistsUser = repository.sp_get_auths_verify_user_estadiadvt(username, password);
        ResponseHandler response = new ResponseHandler();
        if (!isRegister) {
            return response.generateResponse("Peticion exitosa. Usuario ha sido registrado con exito", HttpStatus.OK, registerUser);
        }

        return response.generateResponse("Error, el usuario existe en la base de datos. Inicia sesion para continuar", HttpStatus.I_AM_A_TEAPOT, registerUser);
    }*/
    //</editor-fold>
}
