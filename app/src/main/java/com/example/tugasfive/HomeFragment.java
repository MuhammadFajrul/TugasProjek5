package com.example.tugasfive;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ArrayList<budayapopulerclass> data = new ArrayList<>();
    private ArrayList<daerahsultraclass> data2 = new ArrayList<>();
    private View view,view2;
    private RecyclerView recyclerView,recyclerView2;
    private RecyclerView.LayoutManager layoutManager,layoutManager2;
    String[]nama,namadaerah;
    TypedArray photo,fotodaerah;

    void prepare(){

        nama = getResources().getStringArray(R.array.budayapopuler);
        photo = getResources().obtainTypedArray(R.array.budayapopulerphoto);
    }

    void additem(){
        for (int i = 0 ; i<nama.length;i++){
            budayapopulerclass p =  new budayapopulerclass(nama[i],photo.getResourceId(i,-1));
            data.add(p);
        }
    }

    void getData(){
        prepare();
        additem();
    }

    void preparedaerah(){

        namadaerah = getResources().getStringArray(R.array.namadaerah);
        fotodaerah = getResources().obtainTypedArray(R.array.photodaerah);
    }

    void additemdaerah(){
        for (int i = 0 ; i<namadaerah.length;i++){
            daerahsultraclass p =  new daerahsultraclass(namadaerah[i],fotodaerah.getResourceId(i,-1));
            data2.add(p);
        }
    }

    void getDatadaerah(){
        preparedaerah();
        additemdaerah();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getData();
        getDatadaerah();
        view =inflater.inflate(R.layout.fragment_home2,container,false);
        recyclerView = view.findViewById(R.id.recycleViewHome);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        final budayapopulerAdapter budayapopulerAdapter = new budayapopulerAdapter(getContext(),data);
        recyclerView.setAdapter(budayapopulerAdapter);
        budayapopulerAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.recycleViewHomeDAERAH);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final daerahsultraAdapter daerahsultraAdapter = new daerahsultraAdapter(getContext(),data2);
        recyclerView.setAdapter(daerahsultraAdapter);
        daerahsultraAdapter.notifyDataSetChanged();
        return view;
    }
}