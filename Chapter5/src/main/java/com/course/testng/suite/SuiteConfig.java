package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {

    @BeforeSuite
    public void beforSuite(){
        System.out.println("跑起来！！");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("停下了！！");
    }

    @BeforeTest
    public void beforClass(){
        System.out.println("beforTest 跑喽！！");
    }

    @AfterTest
    public void afterClass(){
        System.out.println("atrerTest 停下来喽！！");
    }
}
