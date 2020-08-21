package com.id.schoolreview.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

import com.id.schoolreview.R;

public class ReviewActivity extends AppCompatActivity {
    RatingBar ratingBar;
    String nilai = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ratingBar = findViewById(R.id.ratingBar);
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
    }
}