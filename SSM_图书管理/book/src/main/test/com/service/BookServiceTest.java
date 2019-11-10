package com.service;

import com.bean.Book;
import com.BasicJunit;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookServiceTest extends BasicJunit {
    @Resource
    private BookService bookService;

    @Test
    public void bookList() {
        List<Book> list = bookService.bookList();
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
