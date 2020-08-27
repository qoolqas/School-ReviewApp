package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataReview;
import com.id.schoolreview.sqlite.DBDataSource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

    Date currentTime;
    SimpleDateFormat sdfc;
    String myFormats = "dd/MM/yyyy hh:mm:ss";
    String kodeid = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        dataSource = new DBDataSource(this);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.btnSubmit);
        deskripsi = findViewById(R.id.deskripsi);
        currentTime = Calendar.getInstance().getTime();
        sdfc = new SimpleDateFormat(myFormats, Locale.US);
        try {
            kode = getIntent().getStringExtra("kode");
            nama = getIntent().getStringExtra("nama");
            edit = getIntent().getStringExtra("edit");
            kodeid = getIntent().getStringExtra("kodeid");
        }catch (Exception e){
            kode = "0";
            kodeid = "0";
            nama = "0";
            edit = "1";
        }
        if (edit.equals("1")) {
            submit.setText("Simpan Perubahan");
            setEdit();
        }

        Log.d("edit", edit+kode);


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
                if (nilai.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Mohon berikan review", Toast.LENGTH_LONG).show();
                }else {
                    if (edit.equals("1")) {
                        editReview();
                    } else {
                        createReview();
                    }
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
        data.setKodeid(sdfc.format(currentTime).replaceAll("/", "").replace(" ", "").replaceAll(":", ""));

        long result = dataSource.createRoti(data);
        if (result > 0) {
            finish();
        }
    }
    private void setEdit(){
        ArrayList<DataReview> forms = dataSource.getRotibyKode(kode);
        if (forms.size() == 1) {
            final DataReview data = forms.get(0);
            deskripsi.setText(data.getDeskripsi());
            ratingBar.setRating(Float.parseFloat(data.getNilai()));

        }
    }
    private void editReview() {
        DataReview data = new DataReview();
        data.setKode(kode);
        data.setNama(nama);
        data.setDeskripsi(deskripsi.getText().toString());
        data.setNilai(nilai);
        data.setKodeid(kodeid);
        long result = dataSource.updateRoti(data);
        if (result > 0) {
            finish();
        }

    }
}