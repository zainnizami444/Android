package com.example.firebasepractice;

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
        EditText txt_fname,txt_lname,txt_contact,txt_pass;
        Button btn_Add, btn_vd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(view -> {
        db = FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");

            txt_fname= findViewById(R.id.txt_Fname);
            txt_lname= findViewById(R.id.txt_Lname);
            txt_contact= findViewById(R.id.txt_Contact);
            txt_pass = findViewById( R.id.txt_Pass);
                btn_vd = findViewById(R.id.btn_vd);
                String id = System.currentTimeMillis()+"";
            Employee emp =new Employee(id,txt_fname.getText().toString(),txt_lname.getText().toString(),txt_contact.getText().toString(),txt_pass.getText().toString());



            db.setValue(emp);
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
        });

    }
}