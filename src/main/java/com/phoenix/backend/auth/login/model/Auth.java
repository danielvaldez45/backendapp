/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenix.backend.auth.login.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author daniel Este objeto pojo representa una abstracion de la tabla:
 * cat_auths.
 *
 */
@Entity
@Table(name = "cat_auths")
public class Auth {

    @Id
    private int id;
    private String username;
    private String password;
    private String token;

    public Auth() {
    }

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Auth(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public Auth(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Auth{" + "id=" + id + ", username=" + username + ", password=" + password + ", token=" + token + '}';
    }
}
