package com.github.paolorotolo.appintro;

public class PermissionObject {
    String[] permission;
    int position;

    public PermissionObject(String[] permission, int position) {
        this.permission = permission;
        this.position = position;
    }

    public String[] getPermission() {
        return this.permission;
    }

    public int getPosition() {
        return this.position;
    }
}
