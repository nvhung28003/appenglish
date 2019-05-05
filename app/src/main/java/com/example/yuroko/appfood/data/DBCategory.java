package com.example.yuroko.appfood.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.yuroko.appfood.entity.English;

import java.util.ArrayList;
import java.util.List;

public class DBCategory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "categorys_manager";
    private static final String TABLE_NAME = "categorys";
    private static final String FIRSTAVATAR = "firstAvatar";
    private static final String TITLE = "title";
    private static final String HREF = "href";
    private static int VERSION = 1;
    private Context context;


    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            FIRSTAVATAR + " TEXT, " +
            TITLE + " TEXT primary key, " +
            HREF + " TEXT)";


    public DBCategory(Context context) {
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

    public void addcategory(English english) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRSTAVATAR, english.getFirstAvatar());
        values.put(TITLE, english.getTitle());
        values.put(HREF, english.getHref());
            db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public List<English> getAllCategory(){

        List<English> listCategory = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db =this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do{

                English english = new English();
                english.setFirstAvatar(cursor.getString(0));
                english.setTitle(cursor.getString(1));
                english.setHref(cursor.getString(2));
                listCategory.add(english);
            }while (cursor.moveToNext());
        }
        db.close();
        return listCategory;
    }
}
