package com.lidadaibiao.springcloud.service;

import com.lidadaibiao.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@Component
public interface DeptClientService {

    @RequestMapping("/dept/query/{id}")   //这里的地址 一定要和提供服务者的地址相同
    Dept queryById(@PathVariable("id") long id);
    @RequestMapping("/dept/queryAll")
    List<Dept>  queryAll();
    @RequestMapping("/dept/add")
    Boolean addDept(Dept dept);
}
