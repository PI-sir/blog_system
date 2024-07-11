package com.halou.controller;


import com.halou.pojo.*;
import com.halou.service.BlogService;
import com.halou.utils.PageBean;
import com.halou.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    //发表博客
    @PostMapping("save")
    public R save(@RequestBody Blog blog){
        int i=blogService.save(blog);
        if(i==1)
            return R.ok("已提交");
        else return R.fail("异常");
    }

    //更改博客
    @PutMapping("update")
    public R update(@RequestBody Blog blog){
        int i=blogService.update(blog);
        if(i==1)
            return R.ok("已更改");
        else  return R.fail("异常");
    }

    //查询博客
    @GetMapping("show/{id}")
    public R show(@PathVariable int id){
        Blog blog=blogService.show(id);
        if(blog!=null)
        return R.ok(blog);
        else return R.fail("异常");
    }


    //删除博客
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable int id){
        int i=blogService.delete(id);
        if(i==1)
            return R.ok(null);
        else  return R.fail("异常");
    }

    //收藏博客
    @PostMapping("collect")
    public R collect(@RequestBody Favourite favourite){
        int i=blogService.collect(favourite);
        System.out.println(favourite);
        if(i==1)
            return R.ok(null);
        else  return R.fail("异常");
    }

    //添加标签
    @PostMapping("tag")
    public R tag(@RequestBody Tag tag){
        int i=blogService.tag(tag);
        if(i==0)
            return  R.fail("异常");
        else return R.ok(null);
    }

    //添加分类
    @PostMapping("newkind")
    public R newkind(@RequestBody Categories categories){
        int i=blogService.newkind(categories);
        if(i==1)
            return R.ok(null);
        else return R.fail("异常");
    }

    //博客分页展示
    @GetMapping("list2/{pageSize}/{currentPage}")
    public R list2(@PathVariable int pageSize,@PathVariable int currentPage){
        PageBean<Blog> pageBean=blogService.list2(pageSize,currentPage);
        return R.ok(pageBean);
    }

    //搜索博客
    @GetMapping("list/{name}")
    public R list(@PathVariable String name){
        List<Blog> list=blogService.list(name);
        return R.ok(list);
    }


    //博客点赞
    @PutMapping("like/{id}")
    public R like(@PathVariable int id){
        int i=blogService.like(id);
        System.out.println(id);
        if(i==0)
            return R.fail("异常");
        else return R.ok(null);
    }

    //取消博客点赞
    @PutMapping("dislike/{id}")
    public R dislike(@PathVariable int id){
        int i=blogService.dislike(id);
        System.out.println(id);
        if(i==0)
            return R.fail("异常");
        else return R.ok(null);
    }



}
