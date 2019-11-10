package com.service.impl;

import com.bean.Users;
import com.dao.UsesrDao;
import com.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsesrDao usesrDao;
    public boolean login(Users users) {
        return usesrDao.selectByUserAndPwd(users).size()>0?true:false;
    }
}
