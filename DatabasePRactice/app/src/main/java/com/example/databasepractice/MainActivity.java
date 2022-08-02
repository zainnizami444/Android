package com.example.databasepractice;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    DatabaseReference db;
    EditText fname, lname, contact;
    Button btn_Add, btn_vd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        contact = findViewById(R.id.contact);
        btn_Add = findViewById(R.id.btn_Add);
        btn_vd = findViewById(R.id.btn_vd);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = System.currentTimeMillis() + "";
                db = FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Person");
                Persons person = new Persons(id, fname.getText().toString(), lname.getText().toString(), contact.getText().toString());
                db.child(id).setValue(person);
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        btn_vd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
            }
        });



    }
}