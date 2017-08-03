package com.example.jonathanguerrero.senasoftapp.adaptadores;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jonathanguerrero.senasoftapp.R;
import com.example.jonathanguerrero.senasoftapp.gestiondatos.Resultado;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jonathanguerrero on 15/04/17.
 */

public class AdaptadorResultados extends RecyclerView.Adapter<AdaptadorResultados.ResultadoViewHolder>{

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    private List<Resultado> resultados;
    private int dia;

    public AdaptadorResultados(List<Resultado> resultados, final int dia) {
        this.resultados = resultados;
        Collections.sort(resultados, new Comparator<Resultado>(){
            @Override
            public int compare(Resultado o1, Resultado o2) {
                switch (dia){
                    case 0:{
                        if(o1.getDia_1() == o2.getDia_1())
                            return 0;
                        return o1.getDia_1() > o2.getDia_1() ? -1 : 1;
                    }
                    case 1:{
                        if(o1.getDia_2() == o2.getDia_2())
                            return 0;
                        return o1.getDia_2() > o2.getDia_2() ? -1 : 1;
                    }
                    case 2:{
                        if(o1.getDia_3() == o2.getDia_3())
                            return 0;
                        return o1.getDia_3() > o2.getDia_3() ? -1 : 1;
                    }
                    case 3:{
                        if(o1.getTotal() == o2.getTotal())
                            return 0;
                        return o1.getTotal() > o2.getTotal() ? -1 : 1;
                    }
                    default:
                        return 0;

                }
            }

        });
        this.dia=dia;
    }

    @Override
    public ResultadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resutado,parent,false);
        ResultadoViewHolder resultadoViewHolder = new ResultadoViewHolder(view);
        return resultadoViewHolder;
    }

    @Override
    public void onBindViewHolder(ResultadoViewHolder holder, int position) {
        Resultado resultado = resultados.get(position);
        holder.bindResultado(resultado,dia);
    }

    public static class ResultadoViewHolder extends RecyclerView.ViewHolder{

        private TextView txtAprendices;
        private TextView txtCentro;
        private TextView txtPuntaje;


        public ResultadoViewHolder(View itemView) {
            super(itemView);
            txtAprendices = (TextView) itemView.findViewById(R.id.participantes);
            txtCentro = (TextView) itemView.findViewById(R.id.centroformacion);
            txtPuntaje = (TextView) itemView.findViewById(R.id.puntaje);
        }
        public void bindResultado(Resultado resultado, int dia){
            txtAprendices.setText(resultado.getAprendices());
            txtCentro.setText(resultado.getRegion());
            switch (dia){
                case 0:
                    txtPuntaje.setText(""+resultado.getDia_1());
                    break;
                case 1:
                    txtPuntaje.setText(""+resultado.getDia_2());
                    break;
                case 2:
                    txtPuntaje.setText(""+resultado.getDia_3());
                    break;
                case 3:
                    txtPuntaje.setText(""+resultado.getTotal());
                    break;
            }
            /*switch (posicion){
                case 0:
                    imgMedalla.setImageResource(R.drawable.gold);
                    break;
                case 1:
                    imgMedalla.setImageResource(R.drawable.silver);
                    break;
                case 2:
                    imgMedalla.setImageResource(R.drawable.bronze);
                    break;
                default:
                    imgMedalla.setImageResource(R.drawable.ic_menu_camera);
            }*/
        }
    }
}
