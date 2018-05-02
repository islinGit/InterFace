package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetMyCookies {
    public String url;
    public ResourceBundle bundle;
    //存储cookies信息
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        //获取properties文件数据
        bundle=ResourceBundle.getBundle("application", Locale.CANADA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get=new HttpGet(this.url+bundle.getString("getCookies"));
        //HttpClient方法不能获取到cookies的值，DefaultHttpClient可以
        //HttpClient client=new DefaultHttpClient();
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookies的方法
        this.store=client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();

        for (Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+";"+value);
        }
    }

    /**
     *带有Cookies值的访问
     */
    @Test(dependsOnMethods={"testGetCookies"})
    public void getWithCookies() throws IOException {
        //发送带cookies值的请求
        HttpGet get=new HttpGet(this.url+bundle.getString("get.with.cookies"));
        DefaultHttpClient client=new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);

        HttpResponse response=client.execute(get);

        //获取响应状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode:"+statusCode);

        if (statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
