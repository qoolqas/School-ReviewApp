package com.id.schoolreview.ui.home;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataSchool;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerViewsd;
    HomeAdapter adapter;
    private ArrayList<DataSchool> list;
    FloatingActionButton fab;

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
    private String[] location;


    private String[] smpkode;
    private String[] smpnama;
    private String[] smptingkat;
    private String[] smpalamat;
    private TypedArray smpgambar;
    private TypedArray smpbanner;
    private String[] smpsarana;
    private TypedArray smpsarana1;
    private String[] smpprestasi;
    private TypedArray smpprestasi1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewsd = view.findViewById(R.id.recyclersd);
        adapter = new HomeAdapter(getActivity(), list);
        recyclerViewsd.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsd.setAdapter(adapter);
        prepare();
        addItem();
    }

    private void prepare() {
        kode = getResources().getStringArray(R.array.array_kode_sd);
        nama = getResources().getStringArray(R.array.array_nama_sd);
        tingkat = getResources().getStringArray(R.array.array_telfon_sd);
        alamat = getResources().getStringArray(R.array.array_alamat_sd);
        gambar = getResources().obtainTypedArray(R.array.array_gambar_sd);
        banner = getResources().obtainTypedArray(R.array.array_banner_sd);
        sarana = getResources().getStringArray(R.array.array_sarana_sd);
        sarana1 = getResources().obtainTypedArray(R.array.array_sarana1_sd);
        prestasi = getResources().getStringArray(R.array.array_prestasi_sd);
        prestasi1 = getResources().obtainTypedArray(R.array.array_prestasi1_sd);
        location = getResources().getStringArray(R.array.array_location_sd);

    }


    private void addItem() {
        ArrayList<DataSchool> list = new ArrayList<>();
        for (int i = 0; i < nama.length; i++) {
            DataSchool items = new DataSchool();
            items.setKode(kode[i]);
            items.setNama(nama[i]);
            items.setTingkat(tingkat[i]);
            items.setAlamat(alamat[i]);
            items.setGambar(gambar.getResourceId(i, -1));
            items.setBanner(banner.getResourceId(i, -1));
            items.setSarana(sarana[i]);
            items.setSarana1(sarana1.getResourceId(i, -1));
            items.setPrestasi(prestasi[i]);
            items.setPrestasi1(prestasi1.getResourceId(i, -1));
            items.setLocation(location[i]);

            list.add(items);
        }
        adapter = new HomeAdapter(getActivity(), list);
        recyclerViewsd.setAdapter(adapter);
    }
}


