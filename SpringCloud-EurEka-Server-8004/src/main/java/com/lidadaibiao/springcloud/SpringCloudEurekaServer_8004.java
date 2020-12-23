package com.lidadaibiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer_8004 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer_8004.class,args);
    }
}
