package com.course.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups {
    //组测试

    @Test(groups = "lin")
    public void groupsClass1(){
        System.out.println("groupsClass1 运行了");
    }

    @Test(groups = "lin")
    public void groupsClass2(){
        System.out.println("groupsClass2 执行了");
    }

    @BeforeGroups(groups = "lin")
    public void beforeGroups(){
        System.out.println("BeforeGroups 组执行之前");
    }

    @AfterGroups(groups = "lin")
    public void afterGroups(){
        System.out.println("AfterGroups 组执行之后");
    }
}
