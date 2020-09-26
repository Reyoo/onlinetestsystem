package com.onlineedu.outsource.system.security.model;

import com.onlineedu.outsource.system.model.SystemRoleModel;
import org.springframework.security.core.GrantedAuthority;

public class CustomRole implements GrantedAuthority {

    private SystemRoleModel systemRoleModel;

    public CustomRole(SystemRoleModel systemRoleModel) {
        this.systemRoleModel = systemRoleModel;
    }

    @Override
    public String getAuthority() {
        return this.systemRoleModel.getRoleName();
    }
}
