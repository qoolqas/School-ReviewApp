package com.id.schoolreview.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "review.db";
    public static final int DB_VERSION = 2;

    //ROTI
    public static final String TABLE_ROTI = "tableroti";
    public static final String R_ID = "id";
    public static final String R_KODE = "kode";
    public static final String R_KODEID = "kodeid";
    public static final String R_NAMA = "nama";
    public static final String R_DESKRIPSI = "deskripsi";
    public static final String R_NILAI = "harga";


    private static final String db_roti = "create table "
            + TABLE_ROTI + "("
            + R_ID + " INTEGER primary key autoincrement not null,"
            + R_KODE + " text,"
            + R_NAMA + " text,"
            + R_DESKRIPSI + " text,"
            + R_NILAI + " text,"
            + R_KODEID + " text);";

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
