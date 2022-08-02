package com.example.databasepractice;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;


import java.util.ArrayList;


public class ListviewAdapter extends BaseAdapter {
    ArrayList<Persons> data;
    DatabaseReference db;
   Context context;
    TextView fname,lname,contact,id;
    Button btn_Delete;
    public ListviewAdapter(  ArrayList<Persons> data,Context context){

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root = LayoutInflater.from(context).inflate(R.layout.listview_content,null);

        fname = root.findViewById(R.id.tv_fname);
        lname = root.findViewById(R.id.tv_lname);
        contact=root.findViewById(R.id.tv_contact);
        id = root.findViewById(R.id.txt_id);
        btn_Delete = root.findViewById(R.id.btn_Delete);

        id.setText(data.get(i).getId());
        fname.setText(data.get(i).getFname());
        lname.setText(data.get(i).getLname());
        contact.setText(data.get(i).getContact());

//        btn_Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db = FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Persons");
//                db.child(data.get(i).getId()).removeValue();
//                Intent intent = new Intent(context,ViewData.class);
//                context.startActivity(intent);
//
//            }
//
//
//        });
        return root;
    }
}
