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

public class budayapopulerAdapter extends RecyclerView.Adapter<budayapopulerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<budayapopulerclass> data;

    public budayapopulerAdapter(Context context, ArrayList<budayapopulerclass> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_budayapopuler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        budayapopulerclass o = data.get(position);
        holder.photobp.setImageResource(o.getPhotobp());
        holder.nama.setText(o.getNama());
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
