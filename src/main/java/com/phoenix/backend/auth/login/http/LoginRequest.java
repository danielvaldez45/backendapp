package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.Auth;

/**
 *
 * @author daniel Esta clase representa un objeto request.
 */
public class LoginRequest {

    private Auth auth;

    public LoginRequest() {
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "LoginRequest{" + "auth=" + auth + '}';
    }

}
