package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.Auth;

/**
 *
 * @author daniel
 */
public class LoginResponse {

    private int code;
    private String message;
    private Auth data;

    public LoginResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public LoginResponse(int code, String message, Auth data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Auth getData() {
        return data;
    }

    public void setData(Auth data) {
        this.data = data;
    }

}
