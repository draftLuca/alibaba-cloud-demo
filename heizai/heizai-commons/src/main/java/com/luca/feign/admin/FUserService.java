package com.luca.feign.admin;

import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="admin")
public interface FUserService {

    @GetMapping("/sys/user/{id}")
    public ResponseVO<User> get(@PathVariable("id") Long id);
}
