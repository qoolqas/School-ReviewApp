package com.id.schoolreview.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.id.schoolreview.R;
import com.id.schoolreview.pojo.DataSchool;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    private Context context;
    private ArrayList<DataSchool> list;
//    private OnItemClickListener mListener;

    public HomeAdapter(Context context, ArrayList<DataSchool> list) {
        this.context = context;
        this.list = list;
    }
//    public interface OnItemClickListener{
//        void onItemClick(int position);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        mListener = listener;
//    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(
                R.layout.item_list, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        DataSchool items = list.get(position);
        holder.nama.setText(items.getNama());
        holder.alamat.setText(items.getAlamat());
        Glide.with(holder.photo).load(items.getGambar()).into(holder.photo);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        DataSchool clickedItem = list.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("data",clickedItem);
                        context.startActivity(intent);
//                        Toast.makeText(view.getContext(), clickedItem.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (mListener != null) {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION) {
//                            mListener.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }
    }
}
