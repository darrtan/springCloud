package com.tan.springcloud.controller;

import com.tan.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程的http服务，简单的Restful服务模板
//    restTemplate注册到bean中
//    （url，实体：（map），class<T>,responseType）

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }

    @RequestMapping("consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/get"+id,Dept.class);
    }

    @RequestMapping("consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/list",List.class);
    }
}
