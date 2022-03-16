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

    @Id
    @Column(name = "user_id")
    private int id;
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private int yearold;
    private String username;
    //@Type(type="Auth.class")
    //@Column
    //private Auth auth;

    public User() {
    }

    public User(int id, String name, String lastName, int yearold, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.yearold = yearold;
        this.username = username;
        //this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getYearold() {
        return yearold;
    }

    public void setYearold(int yearold) {
        this.yearold = yearold;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
