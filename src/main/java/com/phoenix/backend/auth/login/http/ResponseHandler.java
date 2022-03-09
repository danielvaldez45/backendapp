package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


/**
  * Clase para armar respuesta del servidor perzonalizadasS
  **/
public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, User response) {
        ResponseEntity responseEntity;

        Map<String, Object> map = new HashMap<String, Object>();
        //Custome message and status endpoint.
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", response);
        map.put("isRegister", true);
        map.put("Content-Type", "Application/Json");

        //Create Response entity.
        responseEntity = new ResponseEntity<>(map, status);
        if (status.value() == 200) {
            ResponseEntity.ok();
        }

        return responseEntity;
    }
}
