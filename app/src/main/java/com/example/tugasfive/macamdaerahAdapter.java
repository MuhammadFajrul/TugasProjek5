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

public class macamdaerahAdapter extends RecyclerView.Adapter<macamdaerahAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<macamdaerahclass> data;

    public macamdaerahAdapter(Context context, ArrayList<macamdaerahclass> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public macamdaerahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_macamdaerah, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        macamdaerahclass p = data.get(position);
        holder.nama.setText(p.getNama());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.textViewnamadaerah);
        }
    }
}
