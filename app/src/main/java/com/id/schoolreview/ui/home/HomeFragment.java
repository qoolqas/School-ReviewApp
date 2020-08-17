package com.id.schoolreview.ui.home;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataSchool;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeAdapter.OnItemClickListener{
    RecyclerView recyclerViewsd, recyclerViewsmp, recyclerViewsma;
    HomeAdapter adapter;
    private ArrayList<DataSchool> list;

    private String[] kode;
    private String[] nama;
    private String[] tingkat;
    private String[] alamat;
    private TypedArray gambar;
    private TypedArray banner;
    private String[] sarana;
    private TypedArray sarana1;
    private String[] prestasi;
    private TypedArray prestasi1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewsd = view.findViewById(R.id.recyclersd);
        recyclerViewsmp = view.findViewById(R.id.recyclersmp);
        adapter = new HomeAdapter(getActivity(), list);
        recyclerViewsd.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsmp.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsd.setAdapter(adapter);
        recyclerViewsmp.setAdapter(adapter);
        prepare();
        addItem();
    }
    private void prepare() {
        kode = getResources().getStringArray(R.array.array_kode_sd);
        nama = getResources().getStringArray(R.array.array_nama_sd);
        tingkat = getResources().getStringArray(R.array.array_tingkat_sd);
        alamat = getResources().getStringArray(R.array.array_alamat_sd);
        gambar = getResources().obtainTypedArray(R.array.array_gambar_sd);
        banner = getResources().obtainTypedArray(R.array.array_banner_sd);
        sarana = getResources().getStringArray(R.array.array_sarana_sd);
        sarana1 = getResources().obtainTypedArray(R.array.array_sarana1_sd);
        prestasi = getResources().getStringArray(R.array.array_prestasi_sd);
        prestasi1 = getResources().obtainTypedArray(R.array.array_prestasi1_sd);

    }

    private void addItem() {
        ArrayList<DataSchool> list = new ArrayList<>();
        for (int i = 0; i < nama.length; i++) {
            DataSchool items = new DataSchool();
            items.setNama(nama[i]);
            items.setGambar(gambar.getResourceId(i,-1));
            items.setAlamat(alamat[i]);

            list.add(items);
        }
        adapter = new HomeAdapter(getActivity(), list);
        adapter.setOnItemClickListener(this);
        recyclerViewsd.setAdapter(adapter);
    }


    @Override
    public void onItemClick(int position) {
        DataSchool data = new DataSchool();
        data.setKode(kode[position]);
        data.setNama(nama[position]);
        data.setTingkat(tingkat[position]);
        data.setAlamat(alamat[position]);
        data.setGambar(gambar.getResourceId(position,-1));
        data.setBanner(banner.getResourceId(position,-1));
        data.setSarana(sarana[position]);
        data.setSarana1(sarana1.getResourceId(position,-1));
        data.setPrestasi(prestasi[position]);
        data.setPrestasi1(prestasi1.getResourceId(position,-1));
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("DETAIL_DATA", data);
        startActivity(intent);
    }
}