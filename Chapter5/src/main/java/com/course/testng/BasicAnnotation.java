package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    /**
     * 注释执行顺序
     * test<BeforMethod<BeforClass<com.course.testng.suite
     */
    @Test
    public void test1(){
        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void beforMethod(){
        System.out.println("这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试方法之后执行的");
    }

    @BeforeClass
    public void beforClass(){
        System.out.println("beforClass这是在类运行前执行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类执行之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件 包裹class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件 ");
    }
}
