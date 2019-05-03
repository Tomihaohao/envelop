package com.grabmoney.webclient.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.grabmoney.webclient.domain.personDo;
import com.grabmoney.webclient.mapper.personMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value="/save",method = RequestMethod.GET)
    public String Save() throws Exception{
        personDo personDO = new personDo();
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        personDO.setId(randomUUIDString);
        personDO.setName("张三");
        personDO.setAge("18");
        personMapper.insert(personDO);
        return "success";
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
