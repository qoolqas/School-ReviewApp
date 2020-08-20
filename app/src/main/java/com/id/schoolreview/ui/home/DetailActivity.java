package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.CollapsingToolbarLayout;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(dataSchool.getNama());

        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparent));

        Log.d("test", Objects.requireNonNull(dataSchool).getNama());


    }
}