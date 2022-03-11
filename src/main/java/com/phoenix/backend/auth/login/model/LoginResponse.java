package com.phoenix.backend.auth.login.model;

/**
 *
 * @author daniel
 */
public class LoginResponse {
    private int code;
    private String message;
    private User data;
    private String token;

    public LoginResponse(int code, String message, User data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public LoginResponse(int code, String message, User data, String token) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }   
}
