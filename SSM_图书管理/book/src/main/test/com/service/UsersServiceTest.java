package com.service;

import com.bean.Users;
import com.BasicJunit;
import org.junit.Test;

import javax.annotation.Resource;

public class UsersServiceTest extends BasicJunit {
    @Resource
    UsersService service;
    @Test
    public void login() {
        Users users=new Users();
        users.setId(1);
        users.setPwd("1");
        assert service.login(users)==true:"login failure";
    }
}
