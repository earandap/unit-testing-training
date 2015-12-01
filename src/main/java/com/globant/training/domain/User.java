package com.globant.training.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by eduardoaranda on 01/12/15.
 */
public class User {

    private String username;
    private String email;
    private String password;
    private String fullName;
    private Set<Role> roles;

    public User(String username, String email) {
        this();

        if (username == null)
            throw new IllegalArgumentException("The user name cannot be null");
        if (email == null)
            throw new IllegalArgumentException("The user email cannot be null");

        this.username = username;
        this.email = email;

    }

    public User() {
        roles = new HashSet<Role>();
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

        if (email == null)
            throw new IllegalArgumentException("The user email cannot be null");
        this.email = email;
    }

    public void setUsername(String username) {

        if (username == null)
            throw new IllegalArgumentException("The username cannot be null");

        this.username = username;
    }

    public void setFullName(String fullName) {

        if (fullName == null)
            throw new IllegalArgumentException("The user fullname cannot be null");

        this.fullName = fullName;
    }

    public void setPassword(String password) {
        if (password == null)
            throw new IllegalArgumentException("The password cannot be null");
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean validatePassword(String newPassword) {
        return newPassword.length() >= 5 && newPassword.length() <= 25;
    }

    public void setRole(Role role) {
        this.roles.add(role);
    }

    public void modify(String username2, String email2) {

        /**
         * In this case the error message is not the same of
         * @see com.globant.training.domain.User#setUsername
         * by test definition
         */
        if (username2 == null)
            throw new IllegalArgumentException("The user name cannot be null");

        this.username = username2;

        this.setEmail(email2);


    }

    public void changePassword(String newPassword) {
        this.setPassword(newPassword);
    }

    public boolean hasRole(String role1Name) {
        for (Role role : roles) {
            if(role.getRoleName().equals(role1Name))
                return true;
        }
        return false;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return !(email != null ? !email.equals(user.email) : user.email != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
