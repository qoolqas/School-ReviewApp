package com.id.schoolreview.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class DBDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    private String[] rotidata = new String[]
            {
                    DBHelper.R_KODE,
                    DBHelper.R_NAMA,
                    DBHelper.R_DESKRIPSI,
                    DBHelper.R_HARGA,
                    DBHelper.R_IMAGE,
                    DBHelper.R_SELECTION

            };
    public DBDataSource(Context context) {
        dbHelper = new DBHelper(context, DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public long createRoti(DataRoti dataRoti) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.R_KODE,dataRoti.getR_KODE());
        values.put(DBHelper.R_NAMA ,dataRoti.getR_NAMA());
        values.put(DBHelper.R_DESKRIPSI ,dataRoti.getR_DESKRIPSI());
        values.put(DBHelper.R_HARGA, dataRoti.getR_HARGA());
        values.put(DBHelper.R_IMAGE, dataRoti.getR_IMAGE());
        values.put(DBHelper.R_SELECTION ,dataRoti.getR_SELECTION());

        long insertId = database.insert(DBHelper.TABLE_ROTI, null,values);
        close();
        return insertId;
    }

    private DataRoti cursorToForm(Cursor cursor) {
        open();
        DataRoti data = new DataRoti();
        data.setR_KODE(cursor.getString(0));
        data.setR_NAMA(cursor.getString(1));
        data.setR_DESKRIPSI(cursor.getString(2));
        data.setR_HARGA(cursor.getString(3));
        data.setR_IMAGE(cursor.getString(4));
        data.setR_SELECTION(cursor.getString(5));

        close();
        return data;
    }
    public ArrayList<DataRoti> getAllRoti() {
        open();
        ArrayList<DataRoti> listdata = new ArrayList();
        Cursor cursor = this.database.query(DBHelper.TABLE_ROTI, this.rotidata, DBHelper.R_SELECTION+"=0", null, null, null, DBHelper.R_KODE + " ASC");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            listdata.add(cursorToForm(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listdata;
    }
    public ArrayList<DataRoti> getRotibyKode(String kode) {
        open();
        ArrayList<DataRoti> listdata = new ArrayList();
        Cursor cursor = this.database.query(DBHelper.TABLE_ROTI, this.rotidata, DBHelper.R_KODE+"='"+kode+"'", null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            listdata.add(cursorToForm(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listdata;
    }

    public long deleteRoti(String kode) {
        open();
        long a = this.database.delete(DBHelper.TABLE_ROTI, DBHelper.R_KODE+"='"+kode+"'", null);
        close();
        return a;
    }

    public long updateRoti(DataRoti dataRoti) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.R_KODE,dataRoti.getR_KODE());
        values.put(DBHelper.R_NAMA ,dataRoti.getR_NAMA());
        values.put(DBHelper.R_DESKRIPSI ,dataRoti.getR_DESKRIPSI());
        values.put(DBHelper.R_HARGA, dataRoti.getR_HARGA());
        values.put(DBHelper.R_IMAGE, dataRoti.getR_IMAGE());
        values.put(DBHelper.R_SELECTION ,dataRoti.getR_SELECTION());


        long updateId = database.update(DBHelper.TABLE_ROTI, values, DBHelper.R_KODE+"='"+dataRoti.getR_KODE()+"'", null);
        close();
        return updateId;
    }

}
