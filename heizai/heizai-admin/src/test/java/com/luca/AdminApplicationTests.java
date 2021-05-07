package com.luca;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.luca.entity.User;
import com.luca.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminApplicationTests {

    @Autowired
    IUserService iUserService;

    @Test
    public void serviceCRUD() {
        List<User> users = iUserService.list();
        List<User> list = iUserService.list(Wrappers.lambdaQuery(User.class).eq(User::getAvatarId, 1234).select(User::getId));
        Map<Long, List<User>> resultMap = list.stream().collect(Collectors.groupingBy(User::getDeptId));
        log.info(resultMap.toString());
        /*List<String> collect = list.stream().map(User::getEmail).distinct().collect(Collectors.toList());
        log.info(collect.toString());
        users.forEach(i -> System.out.println(users.toString()));*/
    }

    @Test
    public void updateNull() {

        boolean a = iUserService.updateBatchById(new ArrayList<>());
        log.info(a+"");
    }


}
