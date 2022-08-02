package com.example.firebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyler;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Employee> data;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyler =findViewById(R.id.rv);

      fetch();

        layoutManager = new LinearLayoutManager(MainActivity2.this,RecyclerView.HORIZONTAL,false);
        recyler.setLayoutManager(layoutManager);

    }
    public  void fetch()
    {
        data = new ArrayList<>();
        db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot firedatabase:snapshot.getChildren())
                {
                    Employee emp =  firedatabase.getValue(Employee.class);
                    data.add(emp);

                }

                recyleradator r1 = new recyleradator(data);
                recyler.setAdapter(r1);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    }
