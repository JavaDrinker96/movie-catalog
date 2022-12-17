package com.example.moviecatalog.model;

import lombok.Getter;

@Getter
public enum RoleName {

    SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String value;

    RoleName(String value) {
        this.value = value;
    }

}