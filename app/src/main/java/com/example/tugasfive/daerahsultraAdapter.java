package com.example.tugasfive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class daerahsultraAdapter extends RecyclerView.Adapter<daerahsultraAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<daerahsultraclass> data;

    public daerahsultraAdapter(Context context, ArrayList<daerahsultraclass> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public daerahsultraAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_daerahsultra, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        daerahsultraclass q = data.get(position);
        holder.photobp.setImageResource(q.getPhotobp());
        holder.nama.setText(q.getNama());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photobp;
        private TextView nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photobp = itemView.findViewById(R.id.imageView);
            nama = itemView.findViewById(R.id.textViewnama);
        }
    }
}
