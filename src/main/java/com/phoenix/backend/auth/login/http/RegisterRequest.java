package com.phoenix.backend.auth.login.http;

import javax.persistence.Column;

/**
 *
 * @author daniel
 */
public class RegisterRequest {

    private int user_id;
    private String name;
    private String lastName;
    private int age;
    private String username;
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(int user_id, String name, String lastName, int age, String username, String password) {
        this.user_id = user_id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "RegisterRequest{" + "user_id=" + user_id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", username=" + username + ", password=" + password + '}';
    }

}
