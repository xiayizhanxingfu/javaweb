package com.dao;

import com.BasicJunit;
import com.bean.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookDaoTest extends BasicJunit {
    @Resource
    private BookDao bookDao;

    @Test
    public void selectAllTest() {
        List<Book> list = bookDao.selectAll();
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
