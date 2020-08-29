package com.id.schoolreview.ui.review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataReview;
import com.id.schoolreview.pojo.ReviewProvider;
import com.id.schoolreview.sqlite.DBDataSource;
import com.id.schoolreview.ui.home.ReviewAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class SemuaReviewFragment extends Fragment {
    RecyclerView rv;
    private DBDataSource dataSource;
    ReviewProvider provform;
    private ArrayList<ReviewProvider> arraylistform = new ArrayList<>();
    private ReviewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sd, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataSource = new DBDataSource(getActivity());

        adapter = new ReviewAdapter(getActivity(), arraylistform);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv = view.findViewById(R.id.rv);
        rv.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);

    }
    void getData() {
        arraylistform.clear();
        ArrayList<DataReview> forms = dataSource.getAllRoti();
        //ArrayList<DataReview> forms = dataSource.getAllRoti();
        if (forms.size() > 0) {
            for (int i = 0; i < forms.toArray().length; i++) {
                final DataReview cv = forms.get(i);
                provform = new ReviewProvider(cv.getKode(), cv.getNama(), cv.getDeskripsi(), cv.getNilai(), cv.getKodeid());
                arraylistform.add(provform);
            }
            adapter.notifyDataSetChanged();

        } else {
//            Toast.makeText(getApplicationContext(), "Belum ada review", Toast.LENGTH_LONG).show();
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