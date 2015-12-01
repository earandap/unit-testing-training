package com.globant.training.domain;

import java.util.Set;

/**
 * Created by eduardoaranda on 01/12/15.
 */
public class User {

    private String username;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<Role> roles;

    public User(String username, String email) {

    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean validatePassword(String newPassword) {
        return false;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void modify(String username2, String email2) {

    }

    public void changePassword(String newPassword) {

    }

    public boolean hasRole(String role1Name) {
        return false;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
