package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataSchool;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    DataSchool dataSchool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dataSchool = getIntent().getParcelableExtra("data");

        Log.d("test", Objects.requireNonNull(dataSchool).getNama());


    }
}