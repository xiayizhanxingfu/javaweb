package com.service.impl;

import com.bean.Classify;
import com.dao.ClassifyDao;
import com.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    ClassifyDao dao;
    public List<Classify> list() {
        return dao.selecttAll();
    }

    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    public boolean add(Classify classify) {
        return dao.add(classify);
    }

    public boolean update(Classify classify) {
        return dao.updateById(classify);
    }
}
