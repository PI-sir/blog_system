package com.halou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halou.mapper.BlogMapper;
import com.halou.pojo.*;
import com.halou.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogMapper blogMapper;

    @Override
    public int save(Blog blog) {

        System.out.println(blog);
        int i=blogMapper.save(blog);
            return i;
    }

    @Override
    public int update(Blog blog) {
        int i=blogMapper.update(blog);
        System.out.println(blog);
        return i;
    }

    @Override
    public Blog show(int id) {
        Blog blog=blogMapper.show(id);
        return blog;
    }

    @Override
    public int delete(int id) {
        return blogMapper.delete(id);
    }

    @Override
    public int collect(Favourite favourite) {
        return blogMapper.collect(favourite);
    }

    @Override
    public int tag(Tag tag) {
        return blogMapper.tag(tag);
    }

    @Override
    public int newkind(Categories categories) {
        return blogMapper.newkind(categories);
    }

    @Override
    public PageBean<Blog> list2(int pageSize, int currentPage) {
        PageHelper.startPage(pageSize,currentPage);
        List<Blog> list=blogMapper.list2();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        PageBean<Blog> pageBean = new PageBean<>(currentPage,pageSize,pageInfo.getTotal(),pageInfo.getList());

        log.info("分页查询结果:{}",pageBean);

        return pageBean;
    }

    @Override
    public List<Blog> list(String name) {
        return blogMapper.list(name);
    }
}
