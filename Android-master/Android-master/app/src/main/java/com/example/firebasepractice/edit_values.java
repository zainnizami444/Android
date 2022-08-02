package com.example.firebasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class edit_values extends AppCompatActivity {
    // Variables
         DatabaseReference db;
         EditText up_fname,up_lname,up_contact,up_pass;
         Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_values);
     // Type Casting
        up_fname = findViewById(R.id.up_fname);
        up_lname = findViewById(R.id.up_lname);
        up_contact = findViewById(R.id.up_contact);
        up_pass = findViewById(R.id.up_Pass);
        btn_save = findViewById(R.id.up_save);

        Intent intent = getIntent();
      // Edit
      String id = intent.getStringExtra("id");
      up_fname.setText( intent.getStringExtra("fname"));
      up_lname.setText( intent.getStringExtra("lname"));
      up_contact.setText( intent.getStringExtra("contact"));
      up_pass.setText( intent.getStringExtra("pass"));
      // saving the value
    btn_save.setOnClickListener(view -> {
        db = FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        Employee employee = new Employee(id,up_fname.getText().toString(),up_lname.getText().toString(),up_contact.getText().toString(),up_pass.getText().toString());
        db.child(id).setValue(employee).addOnSuccessListener(edit_values.this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(edit_values.this,"Updated",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(edit_values.this,Listview_fragment.class);
                startActivity(i);
            }
        });
    });

    }
}