package com.halou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halou.mapper.UserMapper;
import com.halou.pojo.User;
import com.halou.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void userregister(User user) {
        userMapper.userregister(user);
    }

    @Override
    public int userlogin(User user) {

        int id=0;
        User user1=userMapper.userlogin(user);

        if(user1.getPassword().equals(user.getPassword())){
            id=user1.getId();

        }

        return  id;
    }

    @Override
    public int userdelete(int id) {
        int id1;
        id1=userMapper.userdelete(id);


        return  id1;
    }

    @Override
    public int userupdate(User user) {
        System.out.println(user);
        int i=userMapper.userupdate(user);
        return i;
    }

    @Override
    public User usershow(int id) {
        User user=userMapper.usershow(id);
        return user;
    }

    @Override
    public PageBean<User> userlist(int pageSize, int currentPage) {
        PageHelper.startPage(pageSize,currentPage);
        List<User> list=userMapper.userlist();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageBean<User> pageBean = new PageBean<>(currentPage,pageSize,pageInfo.getTotal(),pageInfo.getList());

        log.info("分页查询结果:{}",pageBean);

        return pageBean;



    }
}
