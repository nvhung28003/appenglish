package com.example.yuroko.appfood.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.itface.KEY;
import com.example.yuroko.appfood.view.fragment.OpeninformationFragment;

import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private List<Information> informations;
    public ViewpagerAdapter(FragmentManager fm, List<Information> informations) {
        super(fm);
        this.informations = informations;
    }

    @Override
    public Fragment getItem(int position) {
        OpeninformationFragment openinformationFragment= new OpeninformationFragment();

        Bundle b = new Bundle();
        b.putString(KEY.STT,informations.get(position).getStt());
        b.putString(KEY.AVATAR,informations.get(position).getAvatar());
        b.putString(KEY.NOIDUNG,informations.get(position).getNoidung());
        b.putString(KEY.CACHDOC,informations.get(position).getCachdoc());
        b.putString(KEY.GIAITHICH,informations.get(position).getGiaithich());
        b.putString(KEY.TULOAI,informations.get(position).getTuloai());
        b.putString(KEY.VIDU,informations.get(position).getVidu());
        b.putString(KEY.VIDUVIETSUB,informations.get(position).getViduvietsub());
        b.putString(KEY.MP3,informations.get(position).getMp3());
        openinformationFragment.setArguments(b);
        return openinformationFragment  ;
    }

    @Override
    public int getCount() {
        return informations.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
