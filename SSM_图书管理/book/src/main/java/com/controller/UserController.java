package com.controller;

import com.bean.Users;
import com.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UsersService service;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users=new Users(Integer.parseInt(username),password);
        if (service.login(users)) {
            return "forward:/book/list";
        }
        return "redirect:/login.jsp";
    }
}
