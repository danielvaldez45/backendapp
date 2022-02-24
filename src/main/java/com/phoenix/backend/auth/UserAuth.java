package com.phoenix.backend.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cat_auths")
public class UserAuth {
    @GeneratedValue @Id
    private Long id;
    private String username;
    private String password;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" + "username=" + username + ", password=" + password + '}';
    }
}
