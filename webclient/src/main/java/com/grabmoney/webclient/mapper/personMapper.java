package com.grabmoney.webclient.mapper;

import com.alibaba.fastjson.annotation.JSONField;
import com.grabmoney.webclient.domain.personDo;

import java.util.List;


public interface personMapper {
    void insert(personDo personDO);
    personDo getUser(String id);
    List<personDo> findPerson();
}
