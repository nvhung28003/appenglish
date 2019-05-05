package com.example.yuroko.appfood.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.yuroko.appfood.data.DBCategory;
import com.example.yuroko.appfood.data.DBDetail;
import com.example.yuroko.appfood.itface.KEY;
import com.example.yuroko.appfood.jsoup.DataCrawler;
import com.example.yuroko.appfood.entity.English;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.view.adapter.EnglishAdapter;
import com.example.yuroko.appfood.itface.IGetHref;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EnglishAdapter.OnitemClickListener, IGetHref {
    private RecyclerView rcvenglish;
    private EnglishAdapter englishAdapter;
    public static String href;
    private List<English> englishList = new ArrayList<>();
    public static DBCategory dbCategory;
    public static DBDetail dbDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbCategory = new DBCategory(this);
        dbDetail = new DBDetail(this);
        setContentView(R.layout.activty_main);
        rcvenglish = findViewById(R.id.rcvenglish);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvenglish.setLayoutManager(layoutManager);


        DataCrawler dataCrawler = new DataCrawler();
        dataCrawler.crawleData(new DataCrawler.OnResultCallBack() {
            @Override
            public void onSuccess(final List<English> englishes) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       englishList = dbCategory.getAllCategory();
                        englishAdapter = new EnglishAdapter(MainActivity.this, englishList);
                        rcvenglish.setAdapter(englishAdapter);
                        englishAdapter.setOnitemClickListener(MainActivity.this);
                     ;
                    }
                });
            }

            @Override
            public void onFailure(final Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        englishList = dbCategory.getAllCategory();
                        englishAdapter = new EnglishAdapter(MainActivity.this, englishList);
                        rcvenglish.setAdapter(englishAdapter);
                        englishAdapter.setOnitemClickListener(MainActivity.this);
                    }
                });
            }
        });
        initlizeComponents();



    }

    private void initlizeComponents() {

    }

    @Override
    public void OnitemClicked(English english) {

        Intent intent = new Intent(this, InformationActivity.class);
        intent.putExtra(KEY.HREF, english.getHref());
        if (english != null) {
            href = english.getHref();
        }
        this.startActivity(intent);
    }

    @Override
    public String getHref() {
        return href;
    }
}

