package com.kai.bean;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bookName;
	private String bookAuthor;
	private String bookIsbn;
	private Integer classifyId;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(Integer id) {
		this.id = id;
	}

	
	public Book(Integer id, String bookName, String bookAuthor, String bookIsbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookIsbn = bookIsbn;
	}

	/** full constructor */
	public Book(Integer id, String bookName, String bookAuthor, String bookIsbn, Integer classifyId) {
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookIsbn = bookIsbn;
		this.classifyId = classifyId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookIsbn() {
		return this.bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Integer getClassifyId() {
		return this.classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

}