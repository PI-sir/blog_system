package com.halou.service;

import com.halou.pojo.User;
import com.halou.utils.PageBean;

public interface UserService  {
    void userregister(User user);

    int userlogin(User user);

    int userdelete(int id);

    int userupdate(User user);

    User usershow(int id);

     PageBean<User> userlist(int pageSize, int currentPage);
}
