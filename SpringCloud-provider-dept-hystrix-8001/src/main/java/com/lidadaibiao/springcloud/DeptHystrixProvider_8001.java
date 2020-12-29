package com.lidadaibiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eurake中  ---》springcloud-eurake-7001
@EnableDiscoveryClient //服务发现，针对团队开发
@EnableCircuitBreaker//添加对熔断的支持
public class DeptHystrixProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixProvider_8001.class,args);
    }
}
