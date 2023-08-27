package com.example.ycfelix.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {


View view;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        CardView dailyCheckCard=view.findViewById(R.id.dailyCheckCard);
        dailyCheckCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),MainActivity.class));
            }
        });
        CardView luckySpinCard=view.findViewById(R.id.luckySpinCard);
        luckySpinCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),HistoryActivity.class));
            }
        });
        CardView referCardq22=view.findViewById(R.id.referCardq22);
        referCardq22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),DeveloperActivity.class));
            }
        });
        CardView watccchCard=view.findViewById(R.id.watccchCard);
        watccchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),TipsActivity.class));
            }
        });
        //allresult
        CardView referCardq=view.findViewById(R.id.referCardq);
        referCardq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),DailyResultAcxtivity.class));
            }
        });
        //

        return  view;
    }
}