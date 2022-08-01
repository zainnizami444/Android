package com.example.firebasepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class recyleradator extends  RecyclerView.Adapter<recyleradator.view_holder> {

    ArrayList<Employee> data;
    DatabaseReference db;

    public recyleradator(ArrayList<Employee> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2,null);
        view_holder vi = new view_holder(root);
        return vi;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        holder.txt_id.setText(data.get(position).getId());
        holder.txt_fname.setText(data.get(position).getFname());
        holder.txt_lname.setText(data.get(position).getLname());
        holder.txt_contact.setText(data.get(position).getContact());
        holder.txt_pass.setText(data.get(position).getPass());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        TextView txt_id, txt_fname, txt_lname, txt_contact, txt_pass;

        public view_holder(@NonNull View itemView) {
            super(itemView);


            txt_id = itemView.findViewById(R.id.rid);
            txt_fname = itemView.findViewById(R.id.rfname);
            txt_lname = itemView.findViewById(R.id.rlname);
            txt_contact = itemView.findViewById(R.id.rcontact);
            txt_pass = itemView.findViewById(R.id.rpass);
        }
    }
}