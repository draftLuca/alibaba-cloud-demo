package com.luca.feign.admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name="admin")
public interface FUserService {

//    @GetMapping("/sys/user/{id}")
//    public ResponseVO<User> get(@PathVariable("id") Long id);
}
