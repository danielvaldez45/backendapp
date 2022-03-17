package com.phoenix.backend.auth.login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenix.backend.auth.login.model.Auth;
import com.phoenix.backend.auth.login.http.LoginRequest;
import com.phoenix.backend.auth.login.http.LoginResponse;
import com.phoenix.backend.auth.login.http.LogoutRequest;
import com.phoenix.backend.auth.login.http.LogoutResponse;
import com.phoenix.backend.auth.login.http.RegisterRequest;
import com.phoenix.backend.auth.login.http.RegisterResponse;
import com.phoenix.backend.auth.login.model.User;
import com.phoenix.backend.auth.login.repository.AuthRepository;

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
    ResponseEntity register(@RequestBody RegisterRequest request) throws JsonProcessingException {
        System.out.println(request.getUser());

        boolean isSuccess = true;
        Auth auth = new Auth();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRegister = objectMapper.writeValueAsString(request.getUser());
        System.out.println(jsonRegister);

        //Resultado del stored Procedure
        String spRegister = repository.sp_registerUser(jsonRegister);

        if (spRegister != null) {
            User userRegister = objectMapper.readValue(spRegister, User.class);
            //Generar un token fake y settearlo en el cuerpo de la respuesta.
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new RegisterResponse(100, "Registro Exitoso", userRegister));

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
        //String userJson = "{\"username\":\"daniel210\",\"password\":\"password\"}";*/
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonAuth = objectMapper.writeValueAsString(requestLogin.getAuth());

        String spAuth = repository.sp_getAuthBUser(jsonAuth);

        Auth auth = objectMapper.readValue(spAuth, Auth.class);
//        //Desencriptar password y validar
        if (spAuth != null) {
            //Generar un token fake y settearlo en el cuerpo de la respuesta.
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new LoginResponse(102, "Loggeo exitoso!", auth));

        }

//        auth.setToken("123456789");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new LoginResponse(103, "Error, debes registrarte"));
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
