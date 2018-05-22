package com.course.server;

import bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是全部的post请求")
//requesMapptin添加在此处表示该类中的所有请求前都得加上 "/vl"
@RequestMapping("/v1")
public class MyPostMethod {

    //创建一个cookies类，用来装载cookies值
    Cookie cookie;
    public User user;

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

    @RequestMapping(value = "/getMyList",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个带参数的post请求，并返回用户信息列表",httpMethod = "POST")
    public String getMyList(HttpServletRequest request ,
                          @RequestBody User  u){
        //设置一个获取cookies值的方法
        Cookie[] cookies=request.getCookies();
        for (Cookie c: cookies){
            //这里需要注意一些事项：1、== 和 equal
            //==比的是对象的地址  equal比的是对象的值
            if (c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("linjinbo")
                    && u.getPassWord().equals("123456")
                    ){
                user=new User();
                user.setName("林金波");
                user.setSex("男");
                user.setAge("25");
                return user.toString();
            }
        }
        return "请求的数据不正确";
    }
}
