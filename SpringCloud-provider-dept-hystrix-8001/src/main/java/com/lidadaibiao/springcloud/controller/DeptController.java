package com.lidadaibiao.springcloud.controller;

import com.lidadaibiao.springcloud.pojo.Dept;
import com.lidadaibiao.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
        @Autowired
        private DeptService deptService;

        @HystrixCommand(fallbackMethod = "hystrixGet")  //被熔断后调用的方法
        @GetMapping("/dept/query/{id}")
        public Dept queryById(@PathVariable("id")long id){
            Dept dept = deptService.queryByDno(id);
            if (dept==null){
                throw new RuntimeException("id=>"+id+"，不存在该用户，或者信息无法找到");
            }
            return deptService.queryByDno(id);
        }

        //备选方法
        public Dept hystrixGet(@PathVariable("id")long id){
            return new Dept()
                    .setDeptno(id)
                    .setDname("id=>"+id+"，不存在该用户，或者信息无法找到")
                    .setDsource("no this database in mysql");
        }


}
