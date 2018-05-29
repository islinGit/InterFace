package com.course.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private int age;
    private int sex;
    private String peimission;
    private String isDelete;

    @Override
    public String toString(){
        return (
                "id:"+id+","+
                        "userName:"+userName+","+
                        "age:"+age+","+
                        "sex:"+sex+","+
                        "peimission:"+peimission+","+
                        "isDelete:"+isDelete
                );
    }
}
