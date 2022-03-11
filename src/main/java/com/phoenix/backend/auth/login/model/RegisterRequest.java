package com.phoenix.backend.auth.login.model;

import javax.persistence.Column;

/**
 *
 * @author daniel
 */

public class RegisterRequest {
    private String name;
    private String lastName;
    private int edad;
    private String username;
    private String password;
}
