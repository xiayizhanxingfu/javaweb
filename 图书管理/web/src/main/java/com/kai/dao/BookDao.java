package com.kai.dao;

import java.util.List;

import com.kai.bean.Book;

public interface BookDao {
	/**
	 * 	根据分类获取图书列表
	 * @param classify_id 分类id
	 * @return
	 */
	List<Book> findByClassify_id(int classify_id);

	/**
	 * 	根据id删除图书
	 * @param id
	 * @return true:删除成功,false:删除失败
	 */
	boolean deleteById(int id);
	/**
	 * 	更新图书信息
	 * @param book
	 * @return true:更新成功,false:更新失败
	 */
	boolean update(Book book);

	/**
	 * 	添加图书
	 * @param book
	 * @return true:添加成功,false:添加失败
	 */
	boolean addBook(Book book);


}
