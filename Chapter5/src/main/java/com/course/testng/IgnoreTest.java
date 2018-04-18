package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    /**
     * 忽略测试
     * enable 参数
     */

    @Test
    public void ignore(){
        System.out.println("ignore1 执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行");
    }
}
