package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> notes = new ArrayList<>();
	ArrayList<Note>al = new ArrayList<>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView
		lv = findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);
		ArrayList<Note> data = db.getAllNotes();
		db.close();
		al.addAll(data);
		aa = new RevisionNotesArrayAdapter(SecondActivity.this,R.layout.row,al);
		lv.setAdapter(aa);

	}


}
