package com.geeks.danda.constants;

public enum Role {

    ADMIN("A", "Admin"),
    USER("U", "User"),
    VIEWER("V", "Viewer");

    private final String code;
    private final String role;

    Role(String code, String role) {
        this.code = code;
        this.role = role;
    }

    public String code() {
        return code;
    }

    public String role() {
        return role;
    }
}
