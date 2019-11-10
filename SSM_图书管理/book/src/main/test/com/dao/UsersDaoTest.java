package com.dao;

import com.BasicJunit;
import com.bean.Users;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UsersDaoTest extends BasicJunit {
    @Resource
    private UsesrDao usersDao;

    @Test
    public void selectByUserAndPwdTest() {
        Users users=new Users();
        users.setId(1);
        users.setPwd("3");
        List list = usersDao.selectByUserAndPwd(users);
        System.out.println(list.toArray());
    }
}
