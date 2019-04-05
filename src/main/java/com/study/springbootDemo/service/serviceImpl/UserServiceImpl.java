package com.study.springbootDemo.service.serviceImpl;

import com.study.springbootDemo.bean.User;
import com.study.springbootDemo.dao.UserMapper;
import com.study.springbootDemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper userMapper;


    @Override
    public User selectUsername(String username) {
        User user=userMapper.selectUsername(username);
        return user;
    }
}
