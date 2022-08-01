package com.example.insertupdatedeletework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class deleteandselectactivity extends AppCompatActivity {
    DatabaseReference db;
    ArrayList<Employee> data;
    ListView lv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteandselectactivity);

        fetch();
    }

    public  void fetch()
    {
        data = new ArrayList<>();
        db= FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot firedatabase:snapshot.getChildren()){
                    Employee emp =  firedatabase.getValue(Employee.class);
                    data.add(emp);

                }
                lv =findViewById(R.id.lv);
                Listviewadaptor adaptor = new Listviewadaptor(data,deleteandselectactivity.this);
                lv.setAdapter(adaptor);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(deleteandselectactivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}