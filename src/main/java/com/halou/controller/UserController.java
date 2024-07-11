package com.halou.controller;


import com.halou.pojo.User;
import com.halou.service.UserService;
import com.halou.utils.PageBean;
import com.halou.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @PostMapping("register")
    public R userregister(@RequestBody User user){

        userService.userregister(user);
        return R.ok(null);
    }

    //登录
    @PostMapping("login")
    public R userlogin(@RequestBody User user){
        int id=userService.userlogin(user);
        if(id==0)
            return R.fail("用户名或密码错误");
        else
        return R.ok("id="+id);
    }

    //注销用户
    @DeleteMapping("delete/{id}")
    public R userdelete(@PathVariable int id){
        int id1=userService.userdelete(id);
        if(id1==0)
            return R.fail("异常");
        else
            return R.ok("已注销");
    }

    //修改用户信息
    @PutMapping("update")
    public R userupdate(@RequestBody User user){
        int i=userService.userupdate(user);
        if(i==1)
        return R.ok("修改成功");
        else return R.fail("异常");
    }


    //显示个人信息
    @GetMapping("show/{id}")
    public R usershow(@PathVariable int id){
        User user=userService.usershow(id);
        return R.ok(user);
    }

    //显示用户列表分页
    @GetMapping("list/{pageSize}/{currentPage}")
    public R userlist(@PathVariable int pageSize,@PathVariable int currentPage){
       PageBean<User> pageBean=userService.userlist(pageSize,currentPage);
        return R.ok(pageBean);
    }
}
