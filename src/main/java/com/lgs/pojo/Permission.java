package com.lgs.pojo;

public class Permission {
    private Integer id;

    private String permissionName;

    private Integer roleId;

    public Permission(Integer id, String permissionName, Integer roleId) {
        this.id = id;
        this.permissionName = permissionName;
        this.roleId = roleId;
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}