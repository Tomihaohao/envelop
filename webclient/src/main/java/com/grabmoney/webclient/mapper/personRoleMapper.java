package com.grabmoney.webclient.mapper;

import com.grabmoney.webclient.domain.personRole;

public interface personRoleMapper {
    void insert(personRole personrole);
    personRole getRole(String RoleName);
}
