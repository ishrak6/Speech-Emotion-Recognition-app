package com.example.ycfelix.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class Income_Adapter extends RecyclerView.Adapter<Income_Adapter.myview> {
    public List<Model_Test> data;

    public Income_Adapter(List<Model_Test> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.payment,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, final int position) {
holder.customer_name.setText("Date : "+data.get(position).getDate());
        holder.customer_number.setText("Accurecy : "+data.get(position).getAccurecy());
        holder.customer_area.setText("Detected : "+data.get(position).getPerfullmodel());
        holder.logout.setText(""+data.get(position).getPerfullmodel());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myview extends RecyclerView.ViewHolder{
        TextView customer_name,customer_number,customer_area,logout;
        public myview(@NonNull View itemView) {
            super(itemView);
            customer_name=itemView.findViewById(R.id.customer_name);
            customer_number=itemView.findViewById(R.id.customer_number);
            customer_area=itemView.findViewById(R.id.customer_area);
            logout=itemView.findViewById(R.id.logout);
        }
    }
}

