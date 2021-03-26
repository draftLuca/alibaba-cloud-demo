package com.luca.ultraman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class UltramanApplication {
    public static void main(String[] args) {
        SpringApplication.run(UltramanApplication.class, args);
    }
}
