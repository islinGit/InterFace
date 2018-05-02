package com.course.httpClient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test() throws IOException {
        String result;
        //首先需要发送一个get请求
        HttpGet get=new HttpGet("http://www.baidu.com");
        //利用clent.excute()来执行get（post）请求
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        //获取返回的数据，并以string类型输出
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
