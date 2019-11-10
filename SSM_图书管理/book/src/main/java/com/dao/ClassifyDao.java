package com.dao;

import com.bean.Classify;

import java.util.List;

public interface ClassifyDao {
    List<Classify> selecttAll();

    boolean deleteById(int id);

    boolean add(Classify classify);

    boolean updateById(Classify classify);
}
