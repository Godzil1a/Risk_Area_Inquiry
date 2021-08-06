package com.my.test;

import com.my.Pojo.Root;
import com.my.Utils.Tool;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        Tool tool = new Tool();
        Root root = tool.trial();
        List<String> list = tool.toList(root);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

}
