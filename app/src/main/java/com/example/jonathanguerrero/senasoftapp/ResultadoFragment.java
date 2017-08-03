package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.jonathanguerrero.senasoftapp.adaptadores.CustomAndroidGridViewAdapter;
import com.example.jonathanguerrero.senasoftapp.gestiondatos.Resultado;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFragment extends Fragment {

    HttpURLConnection con;
    InputStream in;
    GridView gridView;
    public static List<Resultado> resultados;
    public static String[] gridViewStrings = {
            "Algoritmia",
            "Aplicaciones .NET",
            "Android",
            "Php & Scrum",
            "Base de Datos",
            "Java Web",
            "Animación 3D",
            "Medios Audiovisuales",
            "Multimedia",
            "VideoJuegos",
            "Hardening",
            "Redes de Datos",
            "Video Mapping",
            "Emprendimiento Digital"
    };
    /*public static int[] gridViewImages = {
            R.drawable.algoritmia,
            R.drawable.puntonet,
            R.drawable.android,
            R.drawable.php,
            R.drawable.bd,
            R.drawable.java,
            R.drawable.animacion,
            R.drawable.produccion,
            R.drawable.multimedia,
            R.drawable.videojuegos,
            R.drawable.hardering,
            R.drawable.redes
    };*/
    public static int[] gridViewImages = {
            R.drawable.algoritmia,
            R.drawable.puntonet,
            R.drawable.android,
            R.drawable.php,
            R.drawable.bd,
            R.drawable.java,
            R.drawable.animacion,
            R.drawable.produccion,
            R.drawable.multimedia,
            R.drawable.videojuegos,
            R.drawable.hardering,
            R.drawable.redes,
            R.drawable.mapping,
            R.drawable.emprendimiento
    };
    public ResultadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_resultado, container, false);
        ((MainActivity)getActivity()).setBarTitle(2);
        gridView = (GridView) rootView.findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(getContext(),gridViewStrings,gridViewImages,ResultadoFragment.this));

        return rootView;
    }


}
