package com.phoenix.backend.auth.login.controller;

import com.phoenix.backend.auth.login.model.LoginRequest;
import com.phoenix.backend.auth.login.model.LoginResponse;
import com.phoenix.backend.auth.login.model.LogoutRequest;
import com.phoenix.backend.auth.login.model.LogoutResponse;
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
    String Login() {

        return "Hola mundo";
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity Login(@RequestBody LoginRequest requestLogin) {

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
            //Generar un token fake y settearlo en el cuerpo de la respuesta.
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new LoginResponse(100, "Peticion exitosa", user, "12345678"));

        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new LoginResponse(102, "Algo fallo en el servidor", user));
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
