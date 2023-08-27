package com.example.ycfelix.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class HistoryActivity extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;

    DocumentReference documentReference;
    RecyclerView recyclerView;
    Income_Adapter__2 getDataAdapter1;
    List<Model_Test> getList;
    String url;

    FirebaseUser firebaseUser;

    String cus_name;
    String device_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        toolbar.setTitle("All Result");
        setSupportActionBar(toolbar);
        device_id = DeviceIdUtil.getDeviceName();

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_myarrow);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_myarrow);
        getSupportActionBar().setElevation(10.0f);
        getSupportActionBar().setElevation(10.0f);
        firebaseFirestore=FirebaseFirestore.getInstance();


        getList = new ArrayList<>();
        getDataAdapter1 = new Income_Adapter__2(getList);
        firebaseFirestore = FirebaseFirestore.getInstance();
        documentReference  =  firebaseFirestore.collection("List")
                .document(device_id.toString())
                .collection("List").document();
        recyclerView =findViewById(R.id.rreeeed);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        recyclerView.setAdapter(getDataAdapter1);
        reciveData();


    }
    private void reciveData() {

        firebaseFirestore.collection("List")
                .document(device_id.toString())
                .collection("List")
                .orderBy("time", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange ds : queryDocumentSnapshots.getDocumentChanges()) {
                    if (ds.getType() == DocumentChange.Type.ADDED) {

                 /*String first;
                 first = ds.getDocument().getString("name");
                 Toast.makeText(MainActivity2.this, "" + first, Toast.LENGTH_SHORT).show();*/
                        Model_Test get = ds.getDocument().toObject(Model_Test.class);
                        getList.add(get);
                        getDataAdapter1.notifyDataSetChanged();
                    }

                }
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);

        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }
}