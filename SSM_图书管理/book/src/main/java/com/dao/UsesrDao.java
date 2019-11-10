package com.dao;

import com.bean.Users;

import java.util.List;

public interface UsesrDao {
    List<Users> selectByUserAndPwd(Users user);
}
