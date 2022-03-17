package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.User;

/**
 *
 * @author daniel
 */
public class RegisterResponse {

    private Integer code;
    private String message;
    private User user;

    public RegisterResponse() {
    }

    public RegisterResponse(Integer code, String message, User user) {
        this.code = code;
        this.message = message;
        this.user = user;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
