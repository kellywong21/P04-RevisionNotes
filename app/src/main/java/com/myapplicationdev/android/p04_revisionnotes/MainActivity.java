package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert,btnShow;
    RadioGroup rg;
    RadioButton rb;
    EditText etNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsertNote);
        rg = findViewById(R.id.rgStars);
        etNote = findViewById(R.id.etNote);
        btnShow = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = etNote.getText().toString();
                int selectedButtonId = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedButtonId);
                int noStar = Integer.parseInt(rb.getText().toString());
                DBHelper db = new DBHelper(MainActivity.this);
                Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();;
                db.insertNote(note,noStar);
                db.close();



            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);


            }
        });

    }
}
