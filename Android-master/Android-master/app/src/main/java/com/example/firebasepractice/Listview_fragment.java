package com.example.firebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Listview_fragment extends AppCompatActivity {
    // Variables
    DatabaseReference db;
    ArrayList<Employee> data;
    ListView lv ;
    EditText txt_search;
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_fragment);
      // Type Casting
        lv = findViewById(R.id.lv);
        txt_search = findViewById(R.id.txt_search);
        btn_search = findViewById(R.id.btn_search);
      // Calling Method
      // Calling  Select Method
        fetch();
      // Calling Search Method
        btn_search.setOnClickListener(view -> {
            Search();
        });
    }
    // Select And Search Method
    // Select Method
    public  void fetch()
    {
        data = new ArrayList<>();
        db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                for (DataSnapshot firedatabase:snapshot.getChildren())
                {
                    Employee emp =  firedatabase.getValue(Employee.class);
                    data.add(emp);

                }

                ListviewAdaptor adaptor = new ListviewAdaptor(data,Listview_fragment.this);
                lv.setAdapter(adaptor);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    // Search Method
    public  void Search()
    {
        data = new ArrayList<>();
        db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for (DataSnapshot firedatabase:snapshot.getChildren())
                {

                    Employee emp =  firedatabase.getValue(Employee.class);
                    if(emp.fname.contains(txt_search.getText().toString()) || emp.lname.contains(txt_search.getText().toString()))
                    {
                        data.add(emp);
                    }
                }

                ListviewAdaptor adaptor = new ListviewAdaptor(data,Listview_fragment.this);
                lv.setAdapter(adaptor);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}