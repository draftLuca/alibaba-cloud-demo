package com.luca;

import com.luca.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SampleTest {
    @Test
    public void serviceCRUD() {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("上海分公司");
        stringArrayList.add("上饶分公司");
        List<String> result = stringArrayList.stream().filter(i -> i.contains("上海")).collect(Collectors.toList());
        log.info(result.toString());
    }

    @Test
    public void empty() {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        log.info(ObjectUtils.isEmpty(stringArrayList)+"");
    }


    @Test
    public void math() {
        int day=5;
        long startDay=1616947200000l;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 1; i <= day; i++) {
            System.out.println(startDay);
            long l = startDay + Long.valueOf((i - 1) * (86400000 * 7)) + (86400000 * 6);
            System.out.println(l);
            String format1 = sdf.format(new Date(startDay+(Long.valueOf(i-1)*(86400000*7))+(86400000*6)));
            long l1 = startDay + ((i - 1) * (86400000 * 7));
            System.out.println(l1);

            String format = sdf.format(new Date(startDay+((i-1)*(86400000*7))));
            System.out.println(i);
            System.out.println(format);
            System.out.println(format1);
            System.out.println("-------------------------");
        }
    }

    @Test
    public void addNull() {
        ArrayList<Long> stringArrayList = new ArrayList<>();
        ArrayList<Dept> stringArrayList2 = new ArrayList<>();
        List<Long> collect = stringArrayList2.stream().map(Dept::getId).collect(Collectors.toList());
        stringArrayList.add(1L);
        stringArrayList.removeAll(collect);
        log.info(ObjectUtils.isEmpty(stringArrayList)+"");
    }
}
