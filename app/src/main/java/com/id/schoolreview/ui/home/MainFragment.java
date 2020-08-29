package com.id.schoolreview.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.id.schoolreview.R;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView list = view.findViewById(R.id.cardList);
        CardView review = view.findViewById(R.id.cardReview);
        CardView sd = view.findViewById(R.id.cardSD);
        CardView smp = view.findViewById(R.id.cardSMP);

        list.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_main_to_nav_home, null));
        review.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_main_to_nav_review, null));
        sd.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_main_to_nav_gallery, null));
        smp.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_main_to_nav_slideshow, null));
    }
}