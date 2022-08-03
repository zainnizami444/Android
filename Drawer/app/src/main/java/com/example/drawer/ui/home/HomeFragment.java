package com.example.drawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.ListviewAdapter;
import com.example.drawer.R;
import com.example.drawer.User;
import com.example.drawer.databinding.FragmentHomeBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<User> data;
    DatabaseReference db;
    EditText txt_search;
    ListView lv;

    Button btn_search;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);
        lv = root.findViewById(R.id.lv);
        btn_search = root.findViewById(R.id.btn_search);


        fetch();
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
      

        });
        return root;
        }
          // Select And Search Method
          public void fetch()
        {
        data = new ArrayList<>();

        DatabaseReference  db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot firedata:snapshot.getChildren())
                {
                    User u1 = firedata.getValue(User.class);
                    data.add(u1);
                }
                ListviewAdapter adapter = new ListviewAdapter(data,getContext()); //,Listview_Activity.this);
                lv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void search()
    {
        data = new ArrayList<>();
        db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");
        db.addValueEventListener(new ValueEventListener() {
            @Override                        //datatype    variable
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot firedatabase:snapshot.getChildren())
                {
                    User u1 = firedatabase.getValue(User.class);
                    if(u1.fname.contains(txt_search.getText().toString()) || u1.lname.contains(txt_search.getText().toString()))
                    {
                        data.add(u1);
                    }

                }
                ListviewAdapter adapter = new ListviewAdapter(data,getContext()); //,Listview_Activity.this);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}
