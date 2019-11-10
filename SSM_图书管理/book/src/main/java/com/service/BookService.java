package com.service;

import com.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> bookList();

    boolean deleteById(int id);

    boolean updateById(Book book);

    boolean addBook(Book book);
}
