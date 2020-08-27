package com.id.schoolreview.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.id.schoolreview.R;
import com.id.schoolreview.pojo.ReviewProvider;
import com.id.schoolreview.sqlite.DBDataSource;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ReviewProvider> list;
    private DBDataSource datasource;

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
    public void onBindViewHolder(@NonNull final ReviewAdapter.ViewHolder holder, final int position) {
        datasource = new DBDataSource(context);
        final ReviewProvider items = list.get(position);
        holder.nama.setText(items.getNama());
        holder.deskripsi.setText(items.getDeskripsi());
        holder.ratingBar.setRating(Float.parseFloat(items.getNilai()));

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(context, holder.more);
                popup.inflate(R.menu.crud);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(final MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                new AlertDialog.Builder(context)
                                        .setMessage("Apakah anda yakin akan mengedit data ini?")
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(context, ReviewActivity.class);
                                                intent.putExtra("kode", items.getKode());
                                                intent.putExtra("edit", "1");
                                                intent.putExtra("view", "0");
                                                context.startActivity(intent);


                                            }
                                        })

                                        // A null listener allows the button to dismiss the dialog and take no further action.
                                        .setNegativeButton(android.R.string.no, null)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                                break;
                            case R.id.delete:
                                new AlertDialog.Builder(context)
                                        .setMessage("Are you sure you want to delete this data?")
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Continue with delete operation

                                                long a = datasource.deleteRoti(items.getKode());
                                                if (a > 0) {
                                                    dialog.dismiss();
                                                    ((DetailActivity) context).getData();
                                                } else {
                                                    Toast.makeText(context, "Gagal hapus data, silahkan coba lagi", Toast.LENGTH_LONG).show();
                                                    dialog.dismiss();
                                                }
                                            }
                                        })

                                        // A null listener allows the button to dismiss the dialog and take no further action.
                                        .setNegativeButton(android.R.string.no, null)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, deskripsi,skor, more;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            skor = itemView.findViewById(R.id.skor);
            more = itemView.findViewById(R.id.more);
        }
    }
}
