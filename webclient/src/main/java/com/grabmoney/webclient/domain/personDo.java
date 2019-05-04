package com.grabmoney.webclient.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class personDo implements Serializable {
    private String id;
    private String name;
    private String age;
    private String password;

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age){
        this.age = age;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public HashMap<String,String> getPerson(){
        HashMap<String,String> maps = new HashMap<String,String>();
        maps.put("id",this.id);
        maps.put("name",this.name);
        maps.put("age",this.age);
        maps.put("password",this.password);
        return maps;
    }
}
