package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.google.android.material.textfield.TextInputEditText;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataReview;
import com.id.schoolreview.sqlite.DBDataSource;

import java.util.Objects;

public class ReviewActivity extends AppCompatActivity {
    RatingBar ratingBar;
    String nilai = "";
    Button submit;
    String kode = "";
    String nama = "";
    String edit = "0";
    TextInputEditText deskripsi;
    DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        dataSource = new DBDataSource(this);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.btnSubmit);
        deskripsi = findViewById(R.id.deskripsi);
        try {
            kode = getIntent().getStringExtra("kode");
        }catch (Exception e){
            kode = "0";
        }


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        nilai = "1";
                        break;
                    case 2:
                        nilai = "2";
                        break;
                    case 3:
                        nilai = "3";
                        break;
                    case 4:
                        nilai = "4";
                        break;
                    case 5:
                        nilai = "5";
                        Log.d("nilai", nilai);
                        break;
                    default:
                        nilai = "0";
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit.equals("1")) {
//                    editRoti();
                } else {
                    createReview();
                }

            }
        });
    }
    private void createReview(){
        DataReview data = new DataReview();
        data.setKode(kode);
        data.setNama(nama);
        data.setDeskripsi(Objects.requireNonNull(deskripsi.getText()).toString());
        data.setNilai(nilai);

        long result = dataSource.createRoti(data);
        if (result > 0) {
            finish();
        }
    }
}