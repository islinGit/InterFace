package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    /**
     * 测试模板
     * Extentreports
     */
    @Test
    public void test1() {
        Assert.assertEquals(2, 2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa", "aaa");
    }

    @Test
    public void logDemo() {
        Reporter.log("这是测试用的日志");
        throw new RuntimeException("这是测试时抛出的运行时异常");
    }
}
