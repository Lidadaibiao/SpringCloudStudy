package com.lidadaibiao.springcloud.controller;

import com.lidadaibiao.springcloud.pojo.Dept;
import com.lidadaibiao.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/query/{id}")
    public Dept queryById(@PathVariable("id")long id){
        return deptService.queryByDno(id);
    }

    @GetMapping("/dept/queryAll")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/eurake/discovery/")
    public Object discovery(){
        //获得微服务列表的清单
        List<String> services =  discoveryClient.getServices();
        System.out.println("微服务列表清单："+services);
       //得到一个具体的，微服务实例信息 getInstances(String serviceId); serviceId 服务ID
        List<ServiceInstance> serviceInstanceList =  discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println("URI:"+serviceInstance.getUri());
            System.out.println("port:"+serviceInstance.getPort());
            System.out.println("host:"+serviceInstance.getHost());
            System.out.println("ServiceId:"+serviceInstance.getServiceId());
        }
        return this.discoveryClient;
    }
}
