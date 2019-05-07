package com.grabmoney.webclient.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class personRole {
    private String user_role_id;
    private String role;
    public void setUserRoleId(String id){
        this.user_role_id = id;
    }
    public void setUserRole(String role){
        this.role=role;
    }
    public String getRoleId(){
        return this.user_role_id;
    }
    public String getRole(){
        return this.role;
    }

}
