package com.example.contentproviderapp;

import android.content.ContentValues;

public class Util {

	public static ContentValues getBookCV(Book book){
		ContentValues bookCV = new ContentValues();
		bookCV.put(BooksDatabase.AUTHOR, book.getAuthor());
		bookCV.put(BooksDatabase.COL_BOOK_NAME, book.getBookName());
		bookCV.put(BooksDatabase.COL_PUBLISHER, book.getPublisher());
		bookCV.put(BooksDatabase.COL_PUBLISHING_YEAR, book.getPublishingYear());
		return bookCV;
	}
	
}
