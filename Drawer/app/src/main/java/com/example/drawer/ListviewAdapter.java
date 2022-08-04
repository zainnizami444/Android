package com.example.drawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.drawer.delete.delete;
import com.example.drawer.ui.home.HomeFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    ArrayList<User> data;
    Context context;


    public ListviewAdapter(ArrayList<User> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int position, View root, ViewGroup viewGroup) {

        DatabaseReference db = FirebaseDatabase.getInstance("https://insertupdatedeletepractice-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");

        root = LayoutInflater.from(context).inflate(R.layout.list_view_content,null);
        TextView txtFname = root.findViewById(R.id.lvtxtFname);
        TextView txtLname = root.findViewById(R.id.lvtxtLname);
        TextView txtContact = root.findViewById(R.id.lvtxtContact);
        TextView txtEmail = root.findViewById(R.id.lvtxtEmail);
        Button btnDel = root.findViewById(R.id.lvbtn_delete);
        Button btnUp = root.findViewById(R.id.lvbtn_edit);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db.child(data.get(position).getUid()).removeValue();
                Intent i = new Intent(context,activitydrawer.class);
                context.startActivity(i);
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Edit.class);
                i.putExtra("uid",data.get(position).getUid());
                i.putExtra("fname",data.get(position).getFname());
                i.putExtra("lname", data.get(position).getLname());
                i.putExtra("contact", data.get(position).getContact());
                i.putExtra("email", data.get(position).getEmail());

                context.startActivity(i);
            }
        });

        txtFname.setText(data.get(position).getFname());
        txtLname.setText(data.get(position).getLname());
        txtContact.setText(data.get(position).getContact());
        txtEmail.setText(data.get(position).getEmail());


        return root;
    }
}