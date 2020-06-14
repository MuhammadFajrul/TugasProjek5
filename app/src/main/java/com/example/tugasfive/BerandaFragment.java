package com.example.tugasfive;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BerandaFragment extends Fragment {

    private ArrayList<macamdaerahclass> data = new ArrayList<>();
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    String[]nama;

    void prepare(){
        nama = getResources().getStringArray(R.array.namadaerah);
    }

    void additem(){
        for (int i = 0 ; i<nama.length;i++){
            macamdaerahclass p =  new macamdaerahclass(nama[i]);
            data.add(p);
        }
    }

    void getData(){
        prepare();
        additem();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getData();
        view =inflater.inflate(R.layout.fragment_beranda2,container,false);
        recyclerView = view.findViewById(R.id.recycleViewberanda);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final macamdaerahAdapter macamdaerahAdapter = new macamdaerahAdapter(getContext(),data);
        recyclerView.setAdapter(macamdaerahAdapter);
        macamdaerahAdapter.notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }
}