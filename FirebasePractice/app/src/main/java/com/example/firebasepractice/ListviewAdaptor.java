package com.example.firebasepractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

    public class ListviewAdaptor extends BaseAdapter {
            DatabaseReference db;
            ArrayList<Employee> data;
            Context context;
        //    Button btn_Delete;
            TextView txt_fname,txt_lname,txt_contact,txt_pass;

            public ListviewAdaptor(ArrayList<Employee> data , Context context) {
                this.data =data;
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

           View root = LayoutInflater.from(context).inflate(R.layout.list_view_content,null);
           txt_fname = root.findViewById(R.id.txt_fname);
           txt_lname = root.findViewById(R.id.txt_lname);
           txt_contact = root.findViewById(R.id.txtcontact);
           txt_pass = root.findViewById(R.id.txt_pass);
    //       btn_Delete = root.findViewById(R.id.btn_Delete);
           txt_fname.setText(data.get(i).getFname());
           txt_lname.setText(data.get(i).getLname());
           txt_contact.setText(data.get(i).getContact());
           txt_pass.setText(data.get(i).getPass());
    //
    //        btn_Delete.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {
    //                db = FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Persons");
    //                db.child(data.get(i).getId()).removeValue();
    //
    //
    //            }

    //
    //        });
            return root;
        }
    }
