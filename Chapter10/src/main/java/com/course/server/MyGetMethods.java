package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@RestController
@Api(value = "/",description = "这是我全部的get请求")
public class MyGetMethods {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个接口返回cookies信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息类
        //HttpServerletResponse 装响应信息类
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你成功获取cookies值";
    }

    /**
     * 这是个必须带cookies值的get请求
     * @return
     */
    @RequestMapping(value = "/get/with/cookies",method =RequestMethod.GET )
    @ApiOperation(value = "这是个必须带cookies值的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        //空值验证小技巧
        if(Objects.isNull(cookies)){
            return "你必须携带cookies才能访问";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return null;
    }

    /**
     * 开发一个带有参数的get请求
     * 第一种实现： url=key?value&key=value
     * 模拟商品列表
     */
    @RequestMapping(value = "/get/value",method = RequestMethod.GET)
    @ApiOperation(value = "第一种模拟带参数的请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String,Integer> list=new HashMap();
        list.put("电脑",2000);
        list.put("牙刷",10);
        list.put("xbox",1000);
        return list;
    }

    /**
     *  第二种
     */
    @RequestMapping(value = "get/value/able/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "第二种模拟带参数的请求",httpMethod = "GET")
    public Map<String,Integer> getValue(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> list=new HashMap();
        list.put("电脑",2000);
        list.put("牙刷",start);
        list.put("xbox",end);
        return list;
    }
}
