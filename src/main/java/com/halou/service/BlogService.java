package com.halou.service;

import com.halou.pojo.*;
import com.halou.utils.PageBean;

import java.util.List;

public interface BlogService {
   int save(Blog blog);

   int update(Blog blog);

   Blog show(int id);

   int delete(int id);

   int collect(Favourite favourite);

    int tag(Tag tag);

   int newkind(Categories categories);

   PageBean<Blog> list2(int pageSize, int currentPage);

   List<Blog> list(String name);

    int like(int id);

    int dislike(int id);


    List<Blog> list3();

    int pageview(int id);

    int kindadd(Kind kind);

    List<Blog> list4(String kindname);
}
