package com.example.databasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {
    ArrayList<Persons> data;
    DatabaseReference db;

    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        fetch();

    }

        public void fetch() {

         data =  new ArrayList<>();
            db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Persons");
            db.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                   for (DataSnapshot firebasedata:snapshot.getChildren()){
                       Persons persons = firebasedata.getValue(Persons.class);
                       data.add(persons);

                   }

                     lv = findViewById(R.id.lv);
                   ListviewAdapter adapter = new ListviewAdapter(data,ViewData.this);
                   lv.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(ViewData.this, "Error", Toast.LENGTH_SHORT).show();
                }

            });
        }
}


