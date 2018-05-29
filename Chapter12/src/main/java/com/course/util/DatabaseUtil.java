package com.course.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 说明：创建一个方法放回一个数据库执行对象Sqlsession，方便后期调用
 */
public class DatabaseUtil {

    private static SqlSession getSqlsession() throws IOException {
        //获取数据库资源配置文件
        Reader reader= Resources.getResourceAsReader("databaseConfig");
        //执行配置文件
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        //sqlSession就是能够执行配置文件中的sql语句
        SqlSession sqlSession=factory.openSession();
        return  sqlSession;
    }
}
