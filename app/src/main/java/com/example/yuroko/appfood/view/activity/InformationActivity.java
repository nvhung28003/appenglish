package com.example.yuroko.appfood.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuroko.appfood.data.DBDetail;
import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.itface.IGetHref;
import com.example.yuroko.appfood.itface.KEY;
import com.example.yuroko.appfood.view.adapter.InformationAdapter;
import com.example.yuroko.appfood.jsoup.DataCrawlerOpen;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity implements InformationAdapter.OnitemClickListener, View.OnClickListener {
    private RecyclerView rcvenglish;
    private InformationAdapter informationAdapter;
    private TextView txtpagetitle;
    private IGetHref iGetHref;
    private Button btnbackfirst;
    private List<Information> informationList = new ArrayList<>();
    private String href;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);

        initlizeComponents();

        btnbackfirst.setOnClickListener(this);

        DataCrawlerOpen dataCrawlerOpen = new DataCrawlerOpen();
        dataCrawlerOpen.crawleDataopen(new DataCrawlerOpen.OnResultCallBack() {
            @Override
            public void onSuccess(final List<Information> informations, final String pagetitle) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtpagetitle.setText(pagetitle);
                        informationList = MainActivity.dbDetail.getalldetail(href);
                        informationAdapter = new InformationAdapter(InformationActivity.this, informationList);
                        rcvenglish.setAdapter(informationAdapter);
                        informationAdapter.setOnitemClickListener(InformationActivity.this);
                        OpeninformationActivity.informations = MainActivity.dbDetail.getalldetail(href);
                    }
                });
            }

            @Override
            public void onFailure(final Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InformationActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        informationList = MainActivity.dbDetail.getalldetail(href);
                        informationAdapter = new InformationAdapter(InformationActivity.this, informationList);
                        rcvenglish.setAdapter(informationAdapter);
                        informationAdapter.setOnitemClickListener(InformationActivity.this);
                        OpeninformationActivity.informations = MainActivity.dbDetail.getalldetail(href);
                    }
                });
            }

        });
        xuli();

    }

    private void initlizeComponents() {

        rcvenglish = findViewById(R.id.rcvinformation);
        txtpagetitle = findViewById(R.id.txtpagetitle);
        txtpagetitle.setVisibility(View.VISIBLE);
        btnbackfirst = findViewById(R.id.btnbackfirst);
        btnbackfirst.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvenglish.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        href = intent.getStringExtra(KEY.HREF);


    }

    private void xuli() {


    }

    @Override
    public void OnitemClicked(Information information) {
        Intent intent = new Intent(this, OpeninformationActivity.class);
        intent.putExtra("POSITION", information.getStt());
        this.startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnbackfirst:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}

