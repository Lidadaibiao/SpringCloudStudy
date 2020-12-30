package com.lidadaibiao.springcloud.controller;

import com.lidadaibiao.springcloud.pojo.Dept;
import com.lidadaibiao.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
       return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/query/{id}")
    public Dept get(@PathVariable("id")long id){
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }
}
