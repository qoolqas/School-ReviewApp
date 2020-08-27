package com.id.schoolreview.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataReview;
import com.id.schoolreview.pojo.DataSchool;
import com.id.schoolreview.pojo.ReviewProvider;
import com.id.schoolreview.sqlite.DBDataSource;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    DataSchool dataSchool;
    ImageView banner,poster,sarana1,prestasi1;
    TextView nama, alamat, sarana, prestasi;
    MaterialButton review;

    RecyclerView rv;
    private DBDataSource dataSource;
    ReviewProvider provform;
    private ArrayList<ReviewProvider> arraylistform = new ArrayList<>();
    private ReviewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dataSchool = getIntent().getParcelableExtra("data");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);

        dataSource = new DBDataSource(getApplicationContext());

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

        adapter = new ReviewAdapter(this, arraylistform);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);

        review = findViewById(R.id.btnReview);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, ReviewActivity.class);
                intent.putExtra("kode", dataSchool.getKode());
                intent.putExtra("nama", dataSchool.getNama());
                intent.putExtra("edit", "0");
                startActivity(intent);
            }

        });

    }
    void getData() {
        arraylistform.clear();
        ArrayList<DataReview> forms = dataSource.getRotibyKode(dataSchool.getKode());
        //ArrayList<DataReview> forms = dataSource.getAllRoti();
        if (forms.size() > 0) {
            for (int i = 0; i < forms.toArray().length; i++) {
                final DataReview cv = forms.get(i);
                provform = new ReviewProvider(cv.getKode(),cv.getNama(),cv.getDeskripsi(),cv.getNilai());
                arraylistform.add(provform);
            }
            adapter.notifyDataSetChanged();

        } else {
            Toast.makeText(getApplicationContext(), "Belum ada review", Toast.LENGTH_LONG).show();
            arraylistform.clear();
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
}