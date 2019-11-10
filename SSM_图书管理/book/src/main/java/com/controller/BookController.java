package com.controller;

import com.bean.Book;
import com.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/list")
    public String listBook(HttpServletRequest request) {
        List<Book> list = bookService.bookList();
        request.setAttribute("bookList", list);
        return "book/list";
    }

    @RequestMapping("/delete")
    public String deleteBook(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println(bookService.deleteById(Integer.parseInt(id)) ? "删除成功" : "删除失败");
        return "forward:/book/list";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request) {
        String id = request.getParameter("id");
        request.setAttribute("id", Integer.parseInt(id));
        return "book/update";
    }

    @RequestMapping("/updateBook")
    public String updateBook(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("bookName");
        String author = request.getParameter("bookAuthor");
        String isbn = request.getParameter("bookIsbn");
        String classify = request.getParameter("classifyId");
        Book book = new Book(Integer.parseInt(id), name, author, isbn, Integer.parseInt(classify));
        System.out.println(bookService.updateById(book) ? "更新成功" : "更新失败");
        return "forward:/book/list";
    }

    @RequestMapping("/add")
    public String add() {
        return "book/add";
    }
    @RequestMapping("/addBook")
    public String addBook(HttpServletRequest request) {
        String name = request.getParameter("bookName");
        String author = request.getParameter("bookAuthor");
        String isbn = request.getParameter("bookIsbn");
        String classify = request.getParameter("classifyId");
        Book book = new Book(name, author, isbn, Integer.parseInt(classify));
        System.out.println(bookService.addBook(book) ? "添加成功" : "添加失败");
        return "forward:/book/list";
    }
}
