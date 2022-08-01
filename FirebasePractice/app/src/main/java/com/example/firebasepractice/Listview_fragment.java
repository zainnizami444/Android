package com.example.firebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Listview_fragment extends AppCompatActivity {

        DatabaseReference db;
        ArrayList<Employee> data;
        ListView lv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_fragment);

        fetch();
    }

        public  void fetch()
        {
            data = new ArrayList<>();
            db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
            db.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot firedatabase:snapshot.getChildren()){
                        Employee emp =  firedatabase.getValue(Employee.class);
                        data.add(emp);

                    }
                    lv =findViewById(R.id.lv);
                    ListviewAdaptor adaptor = new ListviewAdaptor(data,Listview_fragment.this);
                    lv.setAdapter(adaptor);
                }



                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
}