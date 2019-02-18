package com.study.springbootDemo.controller;

import com.study.springbootDemo.bean.User;
import com.study.springbootDemo.dao.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    User user;

    @Resource
    UserMapper userMapper;

    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("hello","springboot教程");
        return mav;
    }

    @RequestMapping("/AllMessage")
    public ModelAndView getAllMessage(){
        ModelAndView mav=new ModelAndView();
        user=userMapper.selectAll();
        mav.addObject("user",user);
        mav.setViewName("AllMessage");
        return mav;
    }
}
