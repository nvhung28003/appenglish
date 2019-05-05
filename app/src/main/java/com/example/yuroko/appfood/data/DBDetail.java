package com.example.yuroko.appfood.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.yuroko.appfood.entity.Information;

import java.util.ArrayList;
import java.util.List;

public class DBDetail extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "details_manager";
    private static final String TABLE_NAME = "details";
    private static final String PAGETITLE = "PAGETITLE";
    private static final String STT = "STT";
    private static final String AVATAR = "AVATAR";

    private static final String NOIDUNG = "NOIDUNG";
    private static final String CACHDOC = "CACHDOC";
    private static final String GIAITHICH = "GIAITHICH";

    private static final String TULOAI = "TULOAI";
    private static final String VIDU = "VIDU";
    private static final String VIDUVIETSUB = "VIDUVIETSUB";
    private static final String MP3 = "MP3";
    private static final String HREF = "HREF";
    private static int VERSION = 1;
    private Context context;

    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            PAGETITLE + " TEXT, " +
            STT + " TEXT, " +
            AVATAR + " TEXT, " +
            NOIDUNG + " TEXT primary key, " +
            CACHDOC + " TEXT, " +
            GIAITHICH + " TEXT, " +
            TULOAI + " TEXT, " +
            VIDU + " TEXT, " +
            VIDUVIETSUB + " TEXT, " +
            MP3 + " TEXT, " +
            HREF + " TEXT)";
    public DBDetail(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void adddetail(Information information)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PAGETITLE,information.getPagetitle());
        values.put(STT,information.getStt());
        values.put(AVATAR,information.getAvatar());
        values.put(NOIDUNG,information.getNoidung());
        values.put(CACHDOC,information.getCachdoc());
        values.put(GIAITHICH,information.getGiaithich());
        values.put(TULOAI,information.getTuloai());
        values.put(VIDU,information.getVidu());
        values.put(VIDUVIETSUB,information.getViduvietsub());
        values.put(MP3,information.getMp3());
        values.put(HREF,information.getHref());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<Information> getalldetail(String href)
    {
        List<Information> listdetail = new ArrayList<>();

        String selecquery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selecquery,null);
        if(cursor.moveToFirst())
        {
            do {
                Information information = new Information();
                information.setPagetitle(cursor.getString(0));
                information.setStt(cursor.getString(1));
                information.setAvatar(cursor.getString(2));
                information.setNoidung(cursor.getString(3));
                information.setCachdoc(cursor.getString(4));
                information.setGiaithich(cursor.getString(5));
                information.setTuloai(cursor.getString(6));
                information.setVidu(cursor.getString(7));
                information.setViduvietsub(cursor.getString(8));
                information.setMp3(cursor.getString(9));
                information.setHref(cursor.getString(10));
                listdetail.add(information);
            }while (cursor.moveToNext());
        }
        db.close();
        List<Information> listdetai = new ArrayList<>();
        for(int i=0;i<listdetail.size();i++) {
            if (href.equals(listdetail.get(i).getHref())==true)
            {
                listdetai.add(listdetail.get(i));
            }
        }
        return  listdetai;
    }
}
