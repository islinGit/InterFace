package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PostMyCookies {
    //请求的url
    private String url;
    //获取properties文件数据
    private ResourceBundle bundle;
    //获取cookies的方法
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CANADA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //获取接口uri
        String uri=bundle.getString("getCookies");
        //创建一个get请求
        HttpGet get=new HttpGet(this.url+uri);
        //创建一个执行对象（注意：带有cookies值的请求只能用DefaultHttpClient）
        DefaultHttpClient client=new DefaultHttpClient();
        //执行并接收
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //接收cookies值
        this.store=client.getCookieStore();
        List<Cookie> list=store.getCookies();
        for (Cookie cookie:list){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+";"+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostCookies() throws IOException {
        //post请求的uri
        String uri=bundle.getString("postCookies");
        //创建执行的对象
        DefaultHttpClient client=new DefaultHttpClient();
        //创建一个post请求
        HttpPost post=new HttpPost(this.url+uri);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","linjinbo");
        param.put("age","25");

        //将参数传到方法中
        StringEntity entry=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entry);
        //设置请求头信息 header
        post.setHeader("content-type","application/json");
        //设置cookies值
        client.setCookieStore(this.store);
        //执行并接收返回的信息
        HttpResponse response=client.execute(post);
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，判断是否与预期结果相符合
        //将返回的json格式数据进行接收和转换
        JSONObject resultJson=new JSONObject(result);
        //结果对比
        String success= (String) resultJson.get("linjinbo");
        String status= (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
