package com.luca;

import com.luca.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
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
        String regex = "/s[http:|https:]//[A-Za-z0-9\\._\\?%&+\\-=/#!@#$*()]*/s";
        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(douyinUrlBackfillQuery.getDouyinUrl());
//        if (!matcher.find() || ObjectUtils.isEmpty(matcher.group())) {
//        }
    }

    @Test
    public void code() throws Exception {
        String content = "9.4 bN:/ %gxg %t恤 %一人之下 %夏季和黑荔枝  https://v.douyin.com/ek7fAJM/ 复制此链接，打开Dou音搜索，直接觀kan视频！";
        List<String> strings = Arrays.asList(content.split(" "));
        List<String> urlList = strings.stream().filter(i -> i.contains("https://v.douyin.com")).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(urlList)) {
            log.info("回填数据中没有发现可用抖音链接!");
            return;
        }
        String subUrl = urlList.get(0);
        try {
            URL url = new URL(subUrl);
            URLConnection con = url.openConnection();
            log.info("orignal url: " + con.getURL());
            con.connect();
            InputStream is = con.getInputStream();
            log.info("redirected url: " + con.getURL());
            String s = StringUtils.substringBefore(con.getURL().toString(), "?");
            log.info("result url: " + s);
            is.close();
        } catch (Exception e) {
            log.info( e.toString());
        }
        log.info(subUrl);
    }

    @Test
    public void testNull() {
        boolean equals = Boolean.TRUE.equals(null);
        boolean a = null instanceof Object;
        log.info(equals+"");
        log.info("null is object:"+a);
    }

    @Test
    public void password() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean nayuan = passwordEncoder.matches("nayuan", "$2a$10$ngQY22OcOI/uicOM/UN1L.uFhpWtzWr774gg/TkR./M0dWmG39oru");
        boolean nayuan1 = passwordEncoder.matches("nayuan", "$2a$10$CsZ4mUWWfJVY4XWCJ5NrSex2p7q2OLQqcqXuyxyhW4lprJ4gfIGju");
        log.info(nayuan + "");
        log.info(nayuan1 + "");

        String nayuan2 = passwordEncoder.encode("nayuan");
        String nayuan3 = passwordEncoder.encode("nayuan");
        log.info(nayuan2);
        log.info(nayuan3);
    }


}
