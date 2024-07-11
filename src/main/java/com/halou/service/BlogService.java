package com.halou.service;

import com.halou.pojo.Blog;
import com.halou.pojo.Categories;
import com.halou.pojo.Favourite;
import com.halou.pojo.Tag;
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
}
