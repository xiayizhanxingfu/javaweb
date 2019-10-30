package com.service;

import java.util.List;

public interface TopSearchService {
    /**
     * 获取热搜前10名
     * @return
     */
    public List<String> list();

    /**
     * 获取与关键字相关的信息列表访问量最多的前10条记录
     * @param key
     * @return
     */
    List<String> list(String key);
}
