package com.example.yuroko.appfood.view.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.itface.KEY;

public class OpeninformationActivity extends AppCompatActivity implements View.OnClickListener{
private TextView txtstt;
private ImageView imgavatar;
private TextView txtnoidung;
private TextView txtcachdoc;
private TextView txtgiaithich;
private TextView txttuloai;
private TextView txtvidu;
private TextView txtviduvietsub;
private Button btnback;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.open_open_item);
        initlizeComponents();
        btnback.setOnClickListener(this);


    }


    private void initlizeComponents() {
        txtstt=findViewById(R.id.txtstt);
        imgavatar=findViewById(R.id.imgavatar);
        txtnoidung=findViewById(R.id.txtnoidung);
        txtcachdoc=findViewById(R.id.txtcachdoc);
        txtgiaithich=findViewById(R.id.txtgiaithich);
        txttuloai=findViewById(R.id.txttuloai);
        txtvidu=findViewById(R.id.txtvidu);
        txtviduvietsub=findViewById(R.id.txtviduvietsub);
        btnback=findViewById(R.id.btnback);
        Intent intent=getIntent();
        String stt=intent.getStringExtra(KEY.STT);
        String avatar=intent.getStringExtra(KEY.AVATAR);
        String noidung=intent.getStringExtra(KEY.NOIDUNG);
        String cachdoc=intent.getStringExtra(KEY.CACHDOC);
        String giaithich=intent.getStringExtra(KEY.GIAITHICH);
        String tuloai=intent.getStringExtra(KEY.TULOAI);
        String vidu=intent.getStringExtra(KEY.VIDU);
        String viduvietsub=intent.getStringExtra(KEY.VIDUVIETSUB);

        txtstt.setText(stt);
        Glide.with(this).load(avatar).into(imgavatar);
        txtnoidung.setText(noidung);
        txtcachdoc.setText(cachdoc);
        txtgiaithich.setText(giaithich);
        txttuloai.setText(tuloai);
        txtvidu.setText(vidu);
        txtviduvietsub.setText(viduvietsub);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnback:

                onBackPressed();
                break;
                default:
                    break;
        }
    }
}
