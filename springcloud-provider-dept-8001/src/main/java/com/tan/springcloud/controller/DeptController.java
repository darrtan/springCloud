package com.tan.springcloud.controller;

import com.tan.springcloud.pojo.Dept;
import com.tan.springcloud.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;
//获取一些信息，得到具体的微服务

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept addDept(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }


//    注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
//        获得微服务的清单
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
//        得到一个具体的微服务
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"/n"+
                    instance.getPort()+"/n"+
                    instance.getUri()+"/n"+
                    instance.getServiceId()
                    );
        }
        return this.discoveryClient;

    }
}
