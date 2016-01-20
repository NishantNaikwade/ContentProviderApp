package com.example.contentproviderapp;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public class BooksContentProvider extends ContentProvider{
	
	public static final String AUTHORITY = "com.example.contentproviderapp.BooksContentProvider";
	static final String PROVIDER_NAME = "com.example.contentproviderapp.BooksContentProvider";
	static final String URL = "content://" + PROVIDER_NAME + "/BOOK";
	static final Uri CONTENT_URI = Uri.parse(URL);
	static final int BOOKS = 1;
	static final int BOOK_ID = 2;

	static final UriMatcher uriMatcher;
	private static final String TAG = "BooksContentProvider";

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "BOOK", BOOKS);
		uriMatcher.addURI(PROVIDER_NAME, "BOOK/#", BOOK_ID);
	}

	   private static HashMap<String, String> BOOKS_PROJECTION_MAP;
	
	private SQLiteDatabase sqLiteDatabase;

	
	@Override
	public boolean onCreate() {
		Log.i(TAG, "::Inside onCreate Content Provider::");
		sqLiteDatabase = getContext().openOrCreateDatabase(BooksDatabase.DB_NAME, Context.MODE_PRIVATE, null);
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Log.i(TAG, "::Inside query Content Provider::");		
		try{
			SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		      qb.setTables(BooksDatabase.TABLE_NAME);
		      
		      switch (uriMatcher.match(uri)) {
		         case BOOKS:
		         qb.setProjectionMap(BOOKS_PROJECTION_MAP);
		         break;
		         
		         case BOOK_ID:
		         qb.appendWhere( BooksDatabase.COL_ID + "=" + uri.getPathSegments().get(1));
		         break;
		         
		         default:
		         throw new IllegalArgumentException("Unknown URI " + uri);
		      }
		      
		      if (sortOrder == null || sortOrder == ""){
		         /** 
		         * By default sort on student names
		         */
		         sortOrder = BooksDatabase.COL_BOOK_NAME;
		      }
		      Cursor c = qb.query(sqLiteDatabase,	projection,	selection, selectionArgs,null, null, sortOrder);
		      
		      /**
		      * register to watch a content URI for changes
		      */
		      c.setNotificationUri(getContext().getContentResolver(), uri);
		      return c;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		BooksDatabase booksDatabase = new BooksDatabase(getContext());
		booksDatabase.insert(values);
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
