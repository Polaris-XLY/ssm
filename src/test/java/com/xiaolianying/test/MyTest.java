package com.xiaolianying.test;

import com.xiaolianying.utils.MD5Util;
import org.junit.Test;

public class MyTest {
    @Test
    public void testMD5(){
        String mipwd = MD5Util.getMD5("000000");
        System.out.println(mipwd);
    }
}
