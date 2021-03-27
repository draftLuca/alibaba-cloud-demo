package com.luca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@RefreshScope
@MapperScan("com.luca.mapper")
@EnableFeignClients
public class UltramanApplication {
    public static void main(String[] args) {
        SpringApplication.run(UltramanApplication.class, args);
    }
}