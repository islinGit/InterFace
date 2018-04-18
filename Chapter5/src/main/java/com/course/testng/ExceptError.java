package com.course.testng;

import org.testng.annotations.Test;

public class ExceptError {
    /**
     * 异常测试
     * expectedExceptions 属性 测试要捕获的异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeException(){
        System.out.println("这是一个失败的异常");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionSuccesss(){
        System.out.println("这是一个成功的异常");
        throw new RuntimeException();
    }

}
