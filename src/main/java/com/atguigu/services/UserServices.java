package com.atguigu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.ReturnRecord;
import com.atguigu.bean.User;
import com.atguigu.dao.UserMapper;

@Service
public class UserServices {
	
	  @Autowired
	  UserMapper userMapper;
  public ReturnRecord getUser(String name,String pas){
	  ReturnRecord record = new ReturnRecord();
	  User userValidePassword = new User();
	  User user = new User(name,pas);
   User userFind = 	  userMapper.getUserByName(user);
   boolean isValid  =false;
        if(userFind!=null){
        	 userValidePassword =	userMapper.getUser(user);
        	if(userValidePassword!=null){
        	isValid = true;
        	}
        	else {
        		record.setErrorMessege("密码错误");	}
        }else{
        	record.setErrorMessege("用户不存在！");
        }
        if(isValid){
        	record.setUser(userValidePassword);
        	record.setSuccessMessege("登录成功!");
        }
        return record;
  }
}
