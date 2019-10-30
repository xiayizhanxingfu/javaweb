package com.test;

import com.service.TopSearchService;
import com.service.impl.TopSearchServiceImpl;
import com.servlet.TopSearchServlet;
import com.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class MainTest {
    @Test
    public void test() {
        TopSearchService topSearchService=new TopSearchServiceImpl();
        List<String> list=topSearchService.list("的");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
