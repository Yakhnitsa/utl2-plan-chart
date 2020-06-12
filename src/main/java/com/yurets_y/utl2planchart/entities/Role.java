package com.yurets_y.utl2planchart.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    OTHER;



    @Override
    public String getAuthority() {
        return name();
    }
}
