package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonathanguerrero.senasoftapp.adaptadores.AdaptadorResultados;
import com.example.jonathanguerrero.senasoftapp.gestiondatos.Resultado;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaResultadosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdaptadorResultados adaptadorResultados;

    public ListaResultadosFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_resultados, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle b = this.getArguments();
        List<Resultado> listadoMostrar = null;
        int posicionMostrar = -1;
        int dia=-1;
        if(b != null){
            posicionMostrar = b.getInt("pos");
            dia = b.getInt("dia");
            List<Resultado> resbd = Resultado.listAll(Resultado.class);
            listadoMostrar = filtrarCategoria(posicionMostrar,resbd);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerListadoResultados);
        recyclerView.setHasFixedSize(true);
        adaptadorResultados = new AdaptadorResultados(listadoMostrar,dia);
        recyclerView.setAdapter(adaptadorResultados);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<Resultado> filtrarCategoria(int posicionMostrar, List<Resultado> resultados) {
        List<Resultado> filtrado = new ArrayList<>();
        for (Resultado res: resultados
             ) {
            switch (posicionMostrar){
                case 0: // Algortimia
                    if(res.getCompetencia().equalsIgnoreCase("01 Algoritmia"))
                        filtrado.add(res);
                    break;
                case 1: // .NET
                    if(res.getCompetencia().equalsIgnoreCase("03 Aplicaciones .Net"))
                        filtrado.add(res);
                    break;
                case 2: // Android
                    if(res.getCompetencia().equalsIgnoreCase("04 Aplicaciones Móviles Android"))
                        filtrado.add(res);
                    break;
                case 3: // PHP
                    if(res.getCompetencia().equalsIgnoreCase("05 Aplicaciones Web con PHP y SCRUM"))
                        filtrado.add(res);
                    break;
                case 4: // Bases de Datos
                    if(res.getCompetencia().equalsIgnoreCase("06 Base de Datos"))
                        filtrado.add(res);
                    break;
                case 5: // Java Web
                    if(res.getCompetencia().equalsIgnoreCase("09 Java Web"))
                        filtrado.add(res);
                    break;
                case 6: // Animación 3D
                    if(res.getCompetencia().equalsIgnoreCase("02 Animación 3D"))
                        filtrado.add(res);
                    break;
                case 7: // Producción de Medios
                    if(res.getCompetencia().equalsIgnoreCase("10 Producción de Medios Audiovisuales"))
                        filtrado.add(res);
                    break;
                case 8: // Producción Multimedia
                    if(res.getCompetencia().equalsIgnoreCase("11 Producción de Multimedia"))
                        filtrado.add(res);
                    break;
                case 9: // VideoJuegos
                    if(res.getCompetencia().equalsIgnoreCase("15 Video Juegos"))
                        filtrado.add(res);
                    break;
                case 10: // Hardening
                    if(res.getCompetencia().equalsIgnoreCase("08 Instalación y Hardening de Sistemas Operativos"))
                        filtrado.add(res);
                    break;
                case 11: // Redes
                    if(res.getCompetencia().equalsIgnoreCase("13 Redes de Datos"))
                        filtrado.add(res);
                    break;
                case 12: // VideoMapping
                    if(res.getCompetencia().equalsIgnoreCase("16 Video Mapping"))
                        filtrado.add(res);
                    break;
                case 13: // VideoMapping
                    if(res.getCompetencia().equalsIgnoreCase("17 Emprendimiento Digital"))
                        filtrado.add(res);
                    break;
            }

        }
        return filtrado;
    }


}
