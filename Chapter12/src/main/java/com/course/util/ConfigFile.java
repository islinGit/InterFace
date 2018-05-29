package com.course.util;

import com.course.model.InterfaceName;

import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application");

    public static String getUrl(InterfaceName name){
        //默认本地地址
        String address=bundle.getString("test.url");
        //接口地址
        String uri="";
        //最终拼接地址
        if (name.equals(InterfaceName.ADDUSERINFO)){
            uri=bundle.getString("addUser.uri");
        }else if(name.equals(InterfaceName.GETUSERINFO)){
            uri=bundle.getString("getUserInfo.uri");
        }else if(name.equals(InterfaceName.GETUSERLIST)){
            uri=bundle.getString("getUserList.uri");
        }else if(name.equals(InterfaceName.UPDATEUSERINFO)){
            uri=bundle.getString("updateUserInfo.uri");
        }else if (name.equals(InterfaceName.LOGIN)){
            uri=bundle.getString("login.uri");
        }
        String LastUrl=address+uri;
        return LastUrl;
    }
}
