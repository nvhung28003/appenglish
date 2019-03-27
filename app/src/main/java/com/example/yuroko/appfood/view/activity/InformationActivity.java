package com.example.yuroko.appfood.view.activity;

import android.content.Intent;
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

import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.itface.IGetHref;
import com.example.yuroko.appfood.itface.KEY;
import com.example.yuroko.appfood.jsoup.DataCrawler;
import com.example.yuroko.appfood.view.adapter.InformationAdapter;
import com.example.yuroko.appfood.jsoup.DataCrawlerOpen;

import java.util.List;

public class InformationActivity extends AppCompatActivity implements InformationAdapter.OnitemClickListener,View.OnClickListener {
private RecyclerView rcvenglish;
private InformationAdapter informationAdapter;
private TextView txtpagetitle;
private IGetHref iGetHref;
private Button btnbackfirst;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initlizeComponents();
        btnbackfirst.setOnClickListener(this);

        DataCrawlerOpen dataCrawlerOpen = new DataCrawlerOpen();
        informationAdapter.setOnitemClickListener(this);
        dataCrawlerOpen.crawleDataopen(new DataCrawlerOpen.OnResultCallBack() {
            @Override
            public void onSuccess(final List<Information> informationList, final String pagetitle) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        informationAdapter.setInformationList(informationList);
                        txtpagetitle.setText(pagetitle);
                    }
                });
            }
            @Override
            public void onFailure(final Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InformationActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }

    private void initlizeComponents() {
        rcvenglish  = findViewById(R.id.rcvenglish);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        rcvenglish.setLayoutManager(layoutManager);
        informationAdapter = new InformationAdapter(this);
        rcvenglish.setAdapter(informationAdapter);
        txtpagetitle= findViewById(R.id.txtpagetitle);
        txtpagetitle.setVisibility(View.VISIBLE);
        btnbackfirst= findViewById(R.id.btnbackfirst);
        btnbackfirst.setVisibility(View.VISIBLE);


    }


    @Override
    public void OnitemClicked(Information information) {
        Intent intent=new Intent(this,OpeninformationActivity.class);
        intent.putExtra(KEY.STT,information.getStt());
        intent.putExtra(KEY.AVATAR,information.getAvatar());
        intent.putExtra(KEY.NOIDUNG,information.getNoidung());
        intent.putExtra(KEY.CACHDOC,information.getCachdoc());
        intent.putExtra(KEY.GIAITHICH,information.getGiaithich());
        intent.putExtra(KEY.TULOAI,information.getTuloai());
        intent.putExtra(KEY.VIDU,information.getVidu());
        intent.putExtra(KEY.VIDUVIETSUB,information.getViduvietsub());

        this.startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnbackfirst :
                onBackPressed();
                break;
                default:
                    break;
        }
    }
}

