package com.id.schoolreview.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import com.id.schoolreview.pojo.DataReview;

import java.util.ArrayList;
import java.util.List;

public class DBDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    private String[] rotidata = new String[]
            {
                    DBHelper.R_KODE,
                    DBHelper.R_KODEID,
                    DBHelper.R_NAMA,
                    DBHelper.R_DESKRIPSI,
                    DBHelper.R_NILAI

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

    public long createRoti(DataReview dataRoti) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.R_KODE,dataRoti.getKode());
        values.put(DBHelper.R_NAMA ,dataRoti.getNama());
        values.put(DBHelper.R_DESKRIPSI ,dataRoti.getDeskripsi());
        values.put(DBHelper.R_NILAI, dataRoti.getNilai());

        long insertId = database.insert(DBHelper.TABLE_ROTI, null,values);
        close();
        return insertId;
    }

    private DataReview cursorToForm(Cursor cursor) {
        open();
        DataReview data = new DataReview();
        data.setKode(cursor.getString(0));
        data.setNama(cursor.getString(1));
        data.setDeskripsi(cursor.getString(2));
        data.setNilai(cursor.getString(3));

        close();
        return data;
    }
    public ArrayList<DataReview> getAllRoti() {
        open();
        ArrayList<DataReview> listdata = new ArrayList();
        Cursor cursor = this.database.query(DBHelper.TABLE_ROTI, this.rotidata, null, null, null, null, DBHelper.R_KODE + " ASC");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            listdata.add(cursorToForm(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listdata;
    }
    public ArrayList<DataReview> getRotibyKode(String kode) {
        open();
        ArrayList<DataReview> listdata = new ArrayList();
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
    public ArrayList<DataReview> getRotibyKodeid(String kode) {
        open();
        ArrayList<DataReview> listdata = new ArrayList();
        Cursor cursor = this.database.query(DBHelper.TABLE_ROTI, this.rotidata, DBHelper.R_KODEID+"='"+kode+"'", null, null, null, null);
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
        long a = this.database.delete(DBHelper.TABLE_ROTI, DBHelper.R_KODEID+"='"+kode+"'", null);
        close();
        return a;
    }

    public long updateRoti(DataReview dataRoti) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.R_KODE,dataRoti.getKode());
        values.put(DBHelper.R_NAMA ,dataRoti.getNama());
        values.put(DBHelper.R_DESKRIPSI ,dataRoti.getDeskripsi());
        values.put(DBHelper.R_NILAI, dataRoti.getNilai());


        long updateId = database.update(DBHelper.TABLE_ROTI, values, DBHelper.R_KODEID+"='"+dataRoti.getKodeid()+"'", null);
        close();
        return updateId;
    }

}
