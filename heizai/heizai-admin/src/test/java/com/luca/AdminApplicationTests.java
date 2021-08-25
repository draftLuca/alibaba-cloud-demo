package com.luca;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminApplicationTests {


    @Test
    public void arrayList() {
        ArrayList<String> aaa = new ArrayList<>();
        aaa.add("1");
        ArrayList<String> bbbb = new ArrayList<>();
        bbbb = aaa;
        bbbb.add("2");
        log.info(bbbb.hashCode()+"");
    }

}
