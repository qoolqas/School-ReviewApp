package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataSchool;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    DataSchool dataSchool;
    ImageView banner,poster,sarana1,prestasi1;
    TextView nama, alamat, sarana, prestasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dataSchool = getIntent().getParcelableExtra("data");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);

        poster = findViewById(R.id.detail_poster);
        banner = findViewById(R.id.detail_banner);
        sarana1 = findViewById(R.id.detail_sarana1);
        prestasi1 = findViewById(R.id.detail_prestasi1);

        nama = findViewById(R.id.detail_nama);
        alamat = findViewById(R.id.detail_alamat);
        sarana = findViewById(R.id.detail_sarana);
        prestasi = findViewById(R.id.detail_prestasi);

        Glide.with(this).load(dataSchool.getBanner()).into(banner);
        Glide.with(this).load(dataSchool.getGambar()).into(poster);
        Glide.with(this).load(dataSchool.getSarana1()).into(sarana1);
        Glide.with(this).load(dataSchool.getPrestasi1()).into(prestasi1);

        nama.setText(dataSchool.getNama());
        alamat.setText(dataSchool.getAlamat());
        sarana.setText(dataSchool.getSarana());
        prestasi.setText(dataSchool.getPrestasi());

        collapsingToolbarLayout.setTitle(dataSchool.getNama());

        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparent));

        Log.d("test", Objects.requireNonNull(dataSchool).getNama());
        Log.d("test2", String.valueOf(Objects.requireNonNull(dataSchool).getGambar()));
        Log.d("test3", String.valueOf(Objects.requireNonNull(dataSchool).getBanner()));


    }
}