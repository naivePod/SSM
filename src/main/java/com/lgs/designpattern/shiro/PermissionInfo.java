package com.lgs.designpattern.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 14:31
 * @Description:
 */
public class PermissionInfo {
    private Set<String> roles;
    private Set<String> permissions;

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean isPermitted(String permission) {
        return permissions.contains(permission);
    }
}
