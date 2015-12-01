package com.globant.training.domain;

/**
 * Created by eduardoaranda on 01/12/15.
 */
public class Role {

    private String roleName;

    public Role(String role1Name) {
        this.roleName = role1Name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
