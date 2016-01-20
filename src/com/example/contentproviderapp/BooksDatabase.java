package com.example.contentproviderapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class BooksDatabase extends SQLiteOpenHelper{

	public static int DB_VERSION = 1;
	public static final String DB_NAME = "Books_DB";
	public static final String TABLE_NAME = "BOOK";
	private Context context;
	public static final String COL_ID = "_ID";
	public static final String COL_BOOK_NAME = "BOOK_NAME";
	public static final String COL_PUBLISHER = "PUBLISHER";
	public static final String COL_PUBLISHING_YEAR = "PUBLISHING_YEAR";
	public static final String AUTHOR = "AUTHOR";
	public static final String TAG = "BooksDatabase";
	
	
	public BooksDatabase(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		Log.i(TAG, "::Inside Constructor::");
		this.context = context;
		SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase(BooksDatabase.DB_NAME, Context.MODE_PRIVATE, null);
		Log.i(TAG, "::Inside Constructor:: Database is open : " + sqLiteDatabase.isOpen());
		sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BOOK ('_ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'BOOK_NAME' VARCHAR(30), 'PUBLISHER' VARCHAR(30),'AUTHOR' VARCHAR(50),'PUBLISHING_YEAR' INTEGER(4))");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i(TAG, "::Inside OnCreate::");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public long insert(Book book) {
		Log.i(TAG, "::Inside Insert::");
		SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		long id = sqLiteDatabase.insert("BOOK", null, Util.getBookCV(book));
		Log.i(TAG, "Insert ID : " + id);
		return id;
	}
	
	public long insert(ContentValues book) {
		Log.i(TAG, "::Inside Insert::");
		SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		long id = sqLiteDatabase.insert("BOOK", null, book);
		Log.i(TAG, "Insert ID : " + id);
		return id;
	}
	
	private void update(Book book) {
		// TODO Auto-generated method stub

	}
	
	private void delete(Book book) {
		// TODO Auto-generated method stub

	}
	

}
