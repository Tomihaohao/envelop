package com.grabmoney.webclient.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class personDo implements Serializable {
    private String id;
    private String name;
    private String age;

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age){
        this.age = age;
    }
    public Map<String,String> getPerson(){
        Map<String,String> maps = new HashMap<>();
        maps.put("id",this.id);
        maps.put("name",this.name);
        maps.put("age",this.age);
        return maps;
    }
}
