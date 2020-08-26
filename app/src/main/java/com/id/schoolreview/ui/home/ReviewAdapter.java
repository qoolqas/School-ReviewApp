package com.id.schoolreview.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.id.schoolreview.R;
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
        holder.deskripsi.setText(items.getDeskripsi());
        holder.ratingBar.setRating(Float.parseFloat(items.getNilai()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, deskripsi,skor;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
