package com.phoenix.backend.auth.login.http;

/**
 *
 * @author daniel
 */
public class LogoutResponse {
    private int code;
    private String message;

    public LogoutResponse() {
    }
    
   
    public LogoutResponse(int code, String message) {
        this.code = code;
        this.message = message;
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
}
