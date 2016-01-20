package com.example.contentproviderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener{

	private EditText bookName,author,publisher,publishingYear;
	private Button save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bookName = (EditText) findViewById(R.id.bookName);
		author = (EditText) findViewById(R.id.author);
		publisher = (EditText) findViewById(R.id.publisherName);
		publishingYear = (EditText) findViewById(R.id.publishYear);
		save = (Button)findViewById(R.id.save);
		save.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		BooksDatabase booksDatabase = new BooksDatabase(this);
		Book book = new Book();
		book.setAuthor(author.getText().toString());
		book.setPublisher(publisher.getText().toString());
		book.setBookName(bookName.getText().toString());
		book.setPublishingYear(publishingYear.getText().toString());
		booksDatabase.insert(book);
	}
}
