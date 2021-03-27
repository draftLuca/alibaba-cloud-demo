package com.luca;

import com.luca.entity.User;
import com.luca.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Autowired
    IUserService iUserService;

    @Test
    public void serviceCRUD() {
        List<User> users = iUserService.list();
        users.forEach(i -> System.out.println(users.toString()));
    }
}
