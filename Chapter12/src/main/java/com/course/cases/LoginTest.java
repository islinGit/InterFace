package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.util.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeTest;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "这是测试登录的case")
    public void beforeTest(){
        TestConfig.getUserListUrl= ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserInfoUrl=ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl=ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.loginUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
        //声明HttpClient对象
        TestConfig.defaultHttpClient=new DefaultHttpClient();
    }
}
