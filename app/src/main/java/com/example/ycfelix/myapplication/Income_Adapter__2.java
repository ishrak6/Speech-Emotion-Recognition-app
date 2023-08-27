package com.example.ycfelix.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Income_Adapter__2 extends RecyclerView.Adapter<Income_Adapter__2.myview> {
    public List<Model_Test> data;
FirebaseFirestore firebaseFirestore;
    String device_id;
    public Income_Adapter__2(List<Model_Test> data) {
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
        firebaseFirestore=FirebaseFirestore.getInstance();
        device_id = DeviceIdUtil.getDeviceName();
holder.customer_name.setText("Date : "+data.get(position).getDate());
        holder.customer_number.setText("Accurecy : "+data.get(position).getAccurecy());
        holder.customer_area.setText("Detected : "+data.get(position).getPerfullmodel());
        holder.logout.setText(""+data.get(position).getPerfullmodel());
        holder.card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmation")
                        .setMessage("Are you want to delete this result?")
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        firebaseFirestore.collection("List")
                                .document(device_id.toString())
                                .collection("List")
                                .document(data.get(position).getTime())
                                .delete()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(v.getContext(), "Done", Toast.LENGTH_SHORT).show();
                                            v.getContext().startActivity(new Intent(v.getContext(),HomeActivity.class));
                                        }
                                    }
                                });
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myview extends RecyclerView.ViewHolder{
        TextView customer_name,customer_number,customer_area,logout;
        CardView card_view8;
        public myview(@NonNull View itemView) {
            super(itemView);
            customer_name=itemView.findViewById(R.id.customer_name);
            customer_number=itemView.findViewById(R.id.customer_number);
            customer_area=itemView.findViewById(R.id.customer_area);
            logout=itemView.findViewById(R.id.logout);
            card_view8=itemView.findViewById(R.id.card_view8);
        }
    }
}

