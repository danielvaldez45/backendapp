package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.Auth;

/**
 *
 * @author daniel
 */
public class LogoutRequest {

    private Auth auth;

    public LogoutRequest() {
    }

    public LogoutRequest(Auth auth) {
        this.auth = auth;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}
