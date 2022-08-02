package com.example.insertupdatedeletework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertactivity extends AppCompatActivity {
    DatabaseReference db;
    EditText txt_fname,txt_lname,txt_contact,txt_pass;
    Button btn_Add, btn_vd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertactivity);
        btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(view -> {
            db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");


            txt_fname= findViewById(R.id.txt_Fname);
            txt_lname= findViewById(R.id.txt_Lname);
            txt_contact= findViewById(R.id.txt_Contact);
            txt_pass = findViewById( R.id.txt_Pass);
            btn_vd = findViewById(R.id.btn_vd);
            String id = System.currentTimeMillis()+"";
            Employee emp =new Employee(id,txt_fname.getText().toString(),txt_lname.getText().toString(),txt_contact.getText().toString(),txt_pass.getText().toString());



            db.child(id).setValue(emp);
            Toast.makeText(insertactivity.this, "Inserted", Toast.LENGTH_SHORT).show();
        });

//        btn_vd.setOnClickListener(view ->  {
//
//                Intent intent = new Intent(insertactivity.this,deleteandselectactivity.class);
//                startActivity(intent);
//
//
//        });


    }
}