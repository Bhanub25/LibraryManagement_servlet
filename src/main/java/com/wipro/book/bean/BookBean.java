package com.wipro.book.bean;

public class BookBean {
	private String isbn;
	private String bookname;
	private AuthorBean author;
	private char bookType;
	private float cost;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public AuthorBean getAuthor() {
		return author;
	}
	public void setAuthor(AuthorBean author) {
		this.author = author;
	}
	public char getBookType() {
		return bookType;
	}
	public void setBookType(char bookType) {
		this.bookType = bookType;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
