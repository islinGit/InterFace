package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是全部的post请求")
//requesMapptin添加在此处表示该类中的所有请求前都得加上 "/vl"
@RequestMapping("/v1")
public class MyPostMethod {

    //创建一个cookies类，用来装载cookies值
    Cookie cookie;

    @RequestMapping(value = "/post/login",method = RequestMethod.POST)
    //配置swagger
    @ApiOperation(value = "这是一个带cookies值的post请求",httpMethod = "POST")
    public String login(HttpServletResponse response
            ,@RequestParam(value = "userName",required = false) String username
            ,@RequestParam(value = "passward",required = true) String passward){
        cookie=new Cookie("login","true");
        response.addCookie(cookie);
        if (username.equals("Linjinbo") && passward.equals("123456")){
            return "访问成功";
        }
        return "用户名密码不正确";
    }
}
