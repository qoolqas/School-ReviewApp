package com.id.schoolreview.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "review.db";
    public static final int DB_VERSION = 1;

    //ROTI
    public static final String TABLE_ROTI = "tableroti";
    public static final String R_ID = "id";
    public static final String R_KODE = "kode";
    public static final String R_NAMA = "nama";
    public static final String R_DESKRIPSI = "deskripsi";
    public static final String R_HARGA = "harga";
    public static final String R_IMAGE = "image";
    public static final String R_SELECTION = "selection";


    private static final String db_roti = "create table "
            + TABLE_ROTI + "("
            + R_ID + " INTEGER primary key autoincrement not null,"
            + R_KODE + " text,"
            + R_NAMA + " text,"
            + R_DESKRIPSI + " text,"
            + R_HARGA + " text,"
            + R_IMAGE + " text,"
            + R_SELECTION + " INTEGER default 0);";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(db_roti);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }
}
