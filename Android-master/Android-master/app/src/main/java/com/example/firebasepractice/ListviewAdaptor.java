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
     //  Array list
        ArrayList<Employee> data;
    //   Variables
        Context context;
        DatabaseReference db;
        TextView txt_fname,txt_lname,txt_contact,txt_pass;
        Button btn_Delete, btn_Edit;
    // Constructor
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
        // Type Casting
       View root = LayoutInflater.from(context).inflate(R.layout.list_view_content,null);
       txt_fname = root.findViewById(R.id.txt_fname);
       txt_lname = root.findViewById(R.id.txt_lname);
       txt_contact = root.findViewById(R.id.txtcontact);
       txt_pass = root.findViewById(R.id.txt_pass);
       btn_Delete= root.findViewById(R.id.btn_delete);
       btn_Edit = root.findViewById(R.id.btn_edit);
       //Setting Values
       txt_fname.setText(data.get(i).getFname());
       txt_lname.setText(data.get(i).getLname());
       txt_contact.setText(data.get(i).getContact());
       txt_pass.setText(data.get(i).getPass());
       // Delete
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
                db.child(data.get(i).getId()).removeValue();
                Intent intent = new Intent(context,Listview_fragment.class);
                context.startActivity(intent);

            }
        });
        // Edit
            btn_Edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,edit_values.class);
                    intent.putExtra("id",data.get(i).getId());
                    intent.putExtra("fname",data.get(i).getFname());
                    intent.putExtra("lname",data.get(i).getLname());
                    intent.putExtra("contact",data.get(i).getContact());
                    intent.putExtra("pass",data.get(i).getPass());
                    context.startActivity(intent);
                }
            });
        return root;
    }
}
