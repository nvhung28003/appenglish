package com.example.yuroko.appfood.view.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuroko.appfood.R;
import com.example.yuroko.appfood.itface.KEY;

import java.io.IOException;

public class OpeninformationFragment extends Fragment{
private TextView txtstt;
private ImageView imgavatar;
private TextView txtnoidung;
private TextView txtcachdoc;
private TextView txtgiaithich;
private TextView txttuloai;
private TextView txtvidu;
private TextView txtviduvietsub;
private ImageView mp3;
private View rootview;
private String amthanh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.open_open_information,container,false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initlizeComponents();
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(amthanh);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();
            }
        });
    }

    private void initlizeComponents() {
        txtstt=rootview.findViewById(R.id.txtstt);
        imgavatar=rootview.findViewById(R.id.imgavatar);
        txtnoidung=rootview.findViewById(R.id.txtnoidung);
        txtcachdoc=rootview.findViewById(R.id.txtcachdoc);
        txtgiaithich=rootview.findViewById(R.id.txtgiaithich);
        txttuloai=rootview.findViewById(R.id.txttuloai);
        txtvidu=rootview.findViewById(R.id.txtvidu);
        txtviduvietsub=rootview.findViewById(R.id.txtviduvietsub);
        mp3 = rootview.findViewById(R.id.mp3);


        Bundle bundle = getArguments();


        String stt=bundle.getString(KEY.STT);
        String avatar=bundle.getString(KEY.AVATAR);
        String noidung=bundle.getString(KEY.NOIDUNG);
        String cachdoc=bundle.getString(KEY.CACHDOC);
        String giaithich=bundle.getString(KEY.GIAITHICH);
        String tuloai=bundle.getString(KEY.TULOAI);
        String vidu=bundle.getString(KEY.VIDU);
        String viduvietsub=bundle.getString(KEY.VIDUVIETSUB);
        amthanh  =bundle.getString(KEY.MP3);
        txtstt.setText(stt);
        Glide.with(this).load(avatar).into(imgavatar);
        txtnoidung.setText(noidung);
        txtcachdoc.setText(cachdoc);
        txtgiaithich.setText(giaithich);
        txttuloai.setText(tuloai);
        txtvidu.setText(vidu);
        txtviduvietsub.setText(viduvietsub);


    }

}
