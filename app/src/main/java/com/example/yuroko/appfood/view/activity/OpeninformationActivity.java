package com.example.yuroko.appfood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.view.adapter.ViewpagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OpeninformationActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Button btnback;
    public static List<Information> informations = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_viewpager);

        Intent intent = getIntent();
        String position = intent.getStringExtra("POSITION");

        viewPager = findViewById(R.id.vpg);
        btnback = findViewById(R.id.btnbacktwo);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(),informations);
        viewPager.setAdapter(viewpagerAdapter);

        for(int i=0;i<informations.size();i++)
        {
            if(informations.get(i).getStt().equals(position)){
                viewPager.setCurrentItem(i);
            }
        }




    }
}
