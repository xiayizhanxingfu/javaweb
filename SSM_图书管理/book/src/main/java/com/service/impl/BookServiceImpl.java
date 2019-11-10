package com.service.impl;

import com.bean.Book;
import com.dao.BookDao;
import com.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    public List<Book> bookList() {
        return bookDao.selectAll();
    }

    public boolean deleteById(int id) {
        return bookDao.deleteById(id)>0;
    }

    public boolean updateById(Book book) {
        return bookDao.updateById(book) > 0;
    }

    public boolean addBook(Book book) {
        return bookDao.insertBook(book)>0;
    }
}
