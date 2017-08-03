package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdaptadorCategoria adaptadorCategoria;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setBarTitle(1);
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerCategory);
        recyclerView.setHasFixedSize(true);
        List<Categoria> list = loadCategoryData();
        adaptadorCategoria = new AdaptadorCategoria(list,this);
        recyclerView.setAdapter(adaptadorCategoria);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<Categoria> loadCategoryData() {
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(R.drawable.algoritmia,getResources().getString(R.string.txtTitulo1Categoria),getResources().getString(R.string.txtTexto1Categoria)));
        categorias.add(new Categoria(R.drawable.puntonet,getResources().getString(R.string.txtTitulo2Categoria),getResources().getString(R.string.txtTexto2Categoria)));
        categorias.add(new Categoria(R.drawable.android,getResources().getString(R.string.txtTitulo3Categoria),getResources().getString(R.string.txtTexto3Categoria)));
        categorias.add(new Categoria(R.drawable.php,getResources().getString(R.string.txtTitulo4Categoria),getResources().getString(R.string.txtTexto4Categoria)));
        categorias.add(new Categoria(R.drawable.bd,getResources().getString(R.string.txtTitulo5Categoria),getResources().getString(R.string.txtTexto5Categoria)));
        categorias.add(new Categoria(R.drawable.java,getResources().getString(R.string.txtTitulo6Categoria),getResources().getString(R.string.txtTexto6Categoria)));
        categorias.add(new Categoria(R.drawable.animacion,getResources().getString(R.string.txtTitulo7Categoria),getResources().getString(R.string.txtTexto7Categoria)));
        categorias.add(new Categoria(R.drawable.produccion,getResources().getString(R.string.txtTitulo8Categoria),getResources().getString(R.string.txtTexto8Categoria)));
        categorias.add(new Categoria(R.drawable.multimedia,getResources().getString(R.string.txtTitulo9Categoria),getResources().getString(R.string.txtTexto9Categoria)));
        categorias.add(new Categoria(R.drawable.videojuegos,getResources().getString(R.string.txtTitulo10Categoria),getResources().getString(R.string.txtTexto10Categoria)));
        categorias.add(new Categoria(R.drawable.hardering,getResources().getString(R.string.txtTitulo11Categoria),getResources().getString(R.string.txtTexto11Categoria)));
        categorias.add(new Categoria(R.drawable.redes,getResources().getString(R.string.txtTitulo12Categoria),getResources().getString(R.string.txtTexto12Categoria)));
        categorias.add(new Categoria(R.drawable.mapping,getResources().getString(R.string.txtTitulo13Categoria),getResources().getString(R.string.txtTexto13Categoria)));
        categorias.add(new Categoria(R.drawable.emprendimiento,getResources().getString(R.string.txtTitulo14Categoria),getResources().getString(R.string.txtTexto14Categoria)));
        return categorias;
    }
}
