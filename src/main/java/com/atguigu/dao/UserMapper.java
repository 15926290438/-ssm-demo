package com.atguigu.dao;

import com.atguigu.bean.User;


public interface UserMapper {
   User getUserByName(User user);
   User getUser(User user);
}
