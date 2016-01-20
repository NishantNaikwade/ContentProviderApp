package com.example.contentproviderapp;

public class Book {

	private int _ID;
	private String bookName;
	private String publisher;
	private String author;
	private String publishingYear;
	
	public int get_ID() {
		return _ID;
	}
	public void set_ID(int _ID) {
		this._ID = _ID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(String publishingYear) {
		this.publishingYear = publishingYear;
	}
	
	
	
}
