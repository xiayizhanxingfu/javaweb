package com.dao;

import com.bean.Book;

import java.util.List;

public interface BookDao {
    List<Book> selectAll();

    int deleteById(int id);

    int updateById(Book book);

    int insertBook(Book book);
}
