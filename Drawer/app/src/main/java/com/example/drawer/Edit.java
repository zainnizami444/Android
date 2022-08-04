package com.example.drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drawer.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        EditText up_fname,up_lname,up_email,up_contact;
        Button btn_save;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        up_fname = findViewById(R.id.up_fname);
        up_lname = findViewById(R.id.up_lname);
        up_email = findViewById(R.id.up_email);
        up_contact = findViewById(R.id.up_contact);
        btn_save = findViewById(R.id.up_save);


        String id = intent.getStringExtra("uid");
        up_fname.setText(intent.getStringExtra("fname"));
        up_lname.setText(intent.getStringExtra("lname"));
        up_contact.setText(intent.getStringExtra("contact"));
        up_email.setText(intent.getStringExtra("email"));

        up_contact.setText(intent.getStringExtra("contact"));

        btn_save.setOnClickListener(view->{
            DatabaseReference db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");
            User person = new User(id,up_fname.getText().toString(),up_lname.getText().toString(),up_contact.getText().toString(),up_email.getText().toString());
            db.child(id).setValue(person).addOnSuccessListener(Edit.this, new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(Edit.this, "updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Edit.this, activitydrawer.class);
                    startActivity(i);
                }
            });
        });



    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        onBackPressed();
    }
}

