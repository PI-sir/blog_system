package com.halou.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
//博客
public class Blog {
    private Integer id;
    private Integer author;
    private String title;
    private String text;
    private LocalDateTime createtime;
    private String state;
    private Integer like;
    private Integer collect;
    private Integer kindid;
}
