package com.phoenix.backend.auth.login.http;

import com.phoenix.backend.auth.login.model.User;

/**
 *
 * @author daniel
 */
public class RegisterRequest {

    private User user;

    public RegisterRequest() {
    }

    public RegisterRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" + "user=" + user + '}';
    }
    
}
