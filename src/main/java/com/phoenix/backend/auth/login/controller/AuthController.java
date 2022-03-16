package com.phoenix.backend.auth.login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenix.backend.auth.login.model.Auth;
import com.phoenix.backend.auth.login.http.LoginRequest;
import com.phoenix.backend.auth.login.http.LoginResponse;
import com.phoenix.backend.auth.login.http.LogoutRequest;
import com.phoenix.backend.auth.login.http.LogoutResponse;
import com.phoenix.backend.auth.login.http.RegisterRequest;
import com.phoenix.backend.auth.login.repository.AuthRepository;

import com.phoenix.backend.auth.login.model.User;
import java.io.IOException;

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

    //<editor-fold defaultstate="collapsed" desc="register function">
    @PostMapping(value = "/register", produces = "application/json")
    ResponseEntity register(@RequestBody RegisterRequest registerUser) throws JsonProcessingException {
        System.out.println(registerUser.toString());
        boolean isSuccess = true;
        Auth auth = new Auth();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRegister = objectMapper.writeValueAsString(registerUser);

        isSuccess = repository.sp_registerUser(jsonRegister);
        if (isSuccess) {
            //Generar un token fake y settearlo en el cuerpo de la respuesta.
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new LoginResponse(100, "Registro Exitoso", auth));

        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new LogoutResponse(105, "Error, en el servidor."));
        //return response.generateResponse("Error, el usuario existe en la base de datos. Inicia sesion para continuar", HttpStatus.I_AM_A_TEAPOT, registerUser);
    }

//</editor-fold>
    @GetMapping("/login")
    String Login() {

        return "Hola mundo";
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity Login(@RequestBody LoginRequest requestLogin) throws IOException {
        boolean isExistsUser = true;
        //Recuperamos el objeto Auth (Sirve para validar la identidad del usuario en el sistema)
        //Auth auth = requestLogin.getAuth();

        //Parseamos el objeto como un json
        /*ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(auth);
        System.out.println(jsonString);
        
        //Asignamos una bandera y ejecutamos el Stored Procedured.

        //Refactorizar esto y renombrarlo como un metodo
        isExistsUser = repository.getAuthsVerifyUser(jsonString);*/
        String userJson = "{\"username\":\"daniel210\",\"password\":\"password\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        Auth auth = objectMapper.readValue(userJson, Auth.class);
        System.out.println("Auth: " + auth.toString());

        if (!auth.getPassword().equals("password")) {
            //Generar un token fake y settearlo en el cuerpo de la respuesta.
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new LoginResponse(100, "Error, el usuario no existe en la base de datos"));

        }

        //return ResponseEntity
        //       .status(HttpStatus.INTERNAL_SERVER_ERROR)
        //        .body(new LoginResponse(102, "Algo fallo en el servidor", auth));
        //Generar token
        auth.setToken("123456789");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new LoginResponse(102, "Peticion exitosa", auth));
    }

    @PostMapping(value = "/logout", consumes = "application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity logout(@RequestBody LogoutRequest requestLogin) {
        String token;
        token = requestLogin.getToken();

        if (token.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LogoutResponse(105, "Error, no existe token."));
        }

        //Validar el token en el sp (stored procedure). Consiste en saber si existe el token en la base de datos.
        //boolean isToken = true;
        //Si el token NO es valido se ejecuta el if
        if (!token.equals("12345")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LogoutResponse(105, "El token no es valido o expiro"));
        }

        //Finalmente
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new LogoutResponse(100, "Se cerro la sesion con exito"));
    }

}
