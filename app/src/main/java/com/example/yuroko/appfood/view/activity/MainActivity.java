package com.example.yuroko.appfood.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.yuroko.appfood.itface.KEY;
import com.example.yuroko.appfood.jsoup.DataCrawler;
import com.example.yuroko.appfood.entity.English;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.jsoup.DataCrawlerOpen;
import com.example.yuroko.appfood.view.adapter.EnglishAdapter;
import com.example.yuroko.appfood.itface.IGetHref;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EnglishAdapter.OnitemClickListener,IGetHref{
private RecyclerView rcvenglish;
private EnglishAdapter englishAdapter;
public static String href;
private DataCrawlerOpen dataCrawlerOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initlizeComponents();

        dataCrawlerOpen =new DataCrawlerOpen();

        englishAdapter.setOnitemClickListener(this);
        DataCrawler dataCrawler=new DataCrawler();

        dataCrawler.crawleData(new DataCrawler.OnResultCallBack() {
            @Override
            public void onSuccess(final List<English> englishes) {
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        englishAdapter.setEnglishes(englishes);
                    }
                });
            }

            @Override
            public void onFailure(final Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initlizeComponents() {
        rcvenglish =findViewById(R.id.rcvenglish);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rcvenglish.setLayoutManager(layoutManager);

        englishAdapter = new EnglishAdapter(this);
        rcvenglish.setAdapter(englishAdapter);
    }

    @Override
    public void OnitemClicked(English english) {

        Intent intent =new Intent(this, InformationActivity.class);
        intent.putExtra(KEY.HREF,english.getHref());
        if (english!=null){
            href=english.getHref();
        }

        this.startActivity(intent);
    }

    @Override
    public  String getHref() {
       return href;
    }
}

