package com.example.simpleui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


public class Message extends Activity {
	
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		
		String text = getIntent().getStringExtra("text");
		writefile(text);
		
		textView= (TextView) findViewById(R.id.message);
		textView.setText(readfile());
	}
	
	
	private void writefile(String text){
		try {
			text+="\n";
			FileOutputStream fos = openFileOutput("history.txt", Context.MODE_APPEND);
			try {
				fos.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String readfile(){
		try {
			FileInputStream fis = openFileInput("history.txt");
			byte[] buffer=new byte[1024];
			try {
				fis.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String(buffer);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
