package com.halou.pojo;


//用户

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Character gender; // 'b' 男, 'g' 女
    private LocalDate createtime;
    private Integer qq;
    private Integer age;
    private String address;
    private Integer blogNumber;
    private Integer kindNumber;
    private Integer tagNumber;
}
