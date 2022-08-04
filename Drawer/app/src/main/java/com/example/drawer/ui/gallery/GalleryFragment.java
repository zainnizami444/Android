package com.example.drawer.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.R;
import com.example.drawer.User;
import com.example.drawer.databinding.FragmentGalleryBinding;
import com.example.drawer.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {


    DatabaseReference db;
    EditText txt_fname,txt_lname,txt_contact,txt_email;
    Button btn_Add;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery,container,false);

        btn_Add = root.findViewById(R.id.btn_add);

        btn_Add.setOnClickListener(view -> {
            db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");

            txt_fname= root.findViewById(R.id.add_fname);
            txt_lname= root.findViewById(R.id.add_lname);
            txt_contact=root. findViewById(R.id.add_contact);
            txt_email =root. findViewById( R.id.add_email);

            String id = System.currentTimeMillis()+"";
           User user = new User(id,txt_fname.getText().toString(),txt_lname.getText().toString(),txt_contact.getText().toString(),txt_email.getText().toString());



            db.child(id).setValue(user);
            Snackbar.make(view, "Inserted", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });

        return root;
    }
}