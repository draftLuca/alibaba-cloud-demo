package com.luca;

import com.luca.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

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

    @Test
    public void updateNull() {

        boolean a = iDeptService.updateBatchById(new ArrayList<>());
        log.info(a+"");
    }
}
