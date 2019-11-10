package com.service;

import com.bean.Classify;

import java.util.List;

public interface ClassifyService {
    List<Classify> list();

    boolean deleteById(int id);

    boolean add(Classify classify);

    boolean update(Classify classify);
}
