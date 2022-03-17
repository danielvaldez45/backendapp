package com.phoenix.backend.auth.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author daniel (POJO) Este objeto objeto de dominio representa una entidad de
 * la tabla: cat_users.
 */
@Entity
@Table(name = "cat_users")
public class User {

//    @Column(name = "user_id")
    @Id
    private int user_id;
    private String name;
    private String lastname;
    private int age;
    private String username;
    private String password;
    //@Type(type="Auth.class")
    //@Column
    //private Auth auth;

    public User() {
    }

    public User(String name, String lastname, int age, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(int user_id, String name, String lastname, int age, String username, String password) {
        this.user_id = user_id;
        this.name = name;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        return "User{" + "user_id=" + user_id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", username=" + username + ", password=" + password + '}';
    }

}
