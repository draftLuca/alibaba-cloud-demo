package com.luca.feign.admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="admin")
public interface FUserService {

    @GetMapping("admin/user/{id}")
    public String getServiceInfo(@PathVariable("id") Long id);
}
