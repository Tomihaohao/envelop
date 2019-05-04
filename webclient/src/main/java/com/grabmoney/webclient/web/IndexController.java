package com.grabmoney.webclient.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.grabmoney.webclient.config.PasswordEncoderFactories;
import com.grabmoney.webclient.domain.personDo;
import com.grabmoney.webclient.mapper.personMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.util.*;

@RestController
public class IndexController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private personMapper personMapper;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        return "Hello World";
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public JSONObject Save(@RequestBody personDo personData) throws Exception{
        HashMap<String,String> hashPersonData =  personData.getPerson();
        String name = hashPersonData.get("name");
        String age = hashPersonData.get("age");
        String pass = hashPersonData.get("password");
        String empty = "";
        if(name.equals(empty) || name==null){
            JSONObject jsonobject = new JSONObject();
            Map<String,String> result = new HashMap<String, String>();
            result.put("status","false");
            result.put("code","-10");
            result.put("message","用户名不能为空");
            jsonobject.put("error",result);
            return jsonobject;
        }else if(age.equals(empty) || age==null){
            JSONObject jsonobject = new JSONObject();
            Map<String,String> result = new HashMap<String, String>();
            result.put("status","false");
            result.put("code","-10");
            result.put("message","年龄不能为空");
            jsonobject.put("data",result);
            return jsonobject;
        }else if(pass.equals(empty) || pass==null){
            JSONObject jsonobject = new JSONObject();
            Map<String,String> result = new HashMap<String, String>();
            result.put("status","false");
            result.put("code","-10");
            result.put("message","密码不能为空");
            jsonobject.put("data",result);
            return jsonobject;
        }else{
            System.out.println(name+age+pass);

            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String encode_pass = personData.getPassword();
            String encode = passwordEncoder.encode(encode_pass);
            personDo personDO = new personDo();
            personDO = personData;
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            personDO.setId(randomUUIDString);
            personDO.setPassword(encode);
            personMapper.insert(personDO);

            JSONObject jsonobject = new JSONObject();
            Map<String,String> result = new HashMap<String, String>();
            result.put("status","true");
            result.put("code","10");
            result.put("message","注册成功");
            jsonobject.put("data",result);
            return jsonobject;
        }
    }


    @RequestMapping(value="/getlist",method = RequestMethod.GET)
    public JSONObject getList() throws Exception{
        List<Object> list = new ArrayList<>();
        for(personDo item : personMapper.findPerson()){
            System.out.println(item.getPerson());
            list.add(item.getPerson());
        }
        System.out.print(list);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("list",list);
        return jsonobject;
    }
}
