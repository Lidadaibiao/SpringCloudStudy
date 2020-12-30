package com.lidadaibiao.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class DashBoardDeptConsumer_9091 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardDeptConsumer_9091.class,args);
    }

}
