package com.id.schoolreview.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataReview;
import com.id.schoolreview.pojo.DataSchool;
import com.id.schoolreview.pojo.ReviewProvider;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ReviewProvider> list;

    public ReviewAdapter(Context context, ArrayList<ReviewProvider> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(
                R.layout.item_review, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        ReviewProvider items = list.get(position);
        holder.nama.setText(items.getNama());
        holder.alamat.setText(items.getAlamat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat;
        ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
            photo = itemView.findViewById(R.id.photo);
        }
    }
}
