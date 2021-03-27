package com.luca;

import com.luca.entity.User;
import com.luca.service.IDeptService;
import com.luca.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UltramanApplicationTests {

    @Autowired
    IDeptService iDeptService;

    @Test
    public void serviceCRUD() {
        String test = iDeptService.test(1L);
        log.info(test);
    }
}
