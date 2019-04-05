package com.study.springbootDemo.controller;

import com.study.springbootDemo.bean.User;
import com.study.springbootDemo.dao.UserMapper;
import com.study.springbootDemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@RestController
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private User user;

    @Resource(name="UserServiceImpl")
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    @RequestMapping("/hello")
    public ModelAndView hello(String username){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("hello11");
        mav.addObject("hello",username);
        return mav;
    }

    @RequestMapping("/AllMessage")
    public ModelAndView getAllMessage(){
        ModelAndView mav=new ModelAndView();
//        user=userMapper.selectAll();
        user=userService.selectUsername("lbz");
        mav.addObject("user",user);
        mav.setViewName("AllMessage");
        return mav;
    }

    @RequestMapping("/login")
    public String toLogin(String username,Model model){
        return "myLogin";
    }



    @ResponseBody
    @RequestMapping("/toJson")
    public User toJson(Model model, HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setId(1);
        user.setUsername("zhanghaoliang");
        user.setPassword("1231");
        return user;
    }
}
