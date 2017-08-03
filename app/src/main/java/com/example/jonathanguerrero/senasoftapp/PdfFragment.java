package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PdfFragment extends Fragment {


    public PdfFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pdf, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).showFloattingButton();
        super.onViewCreated(view, savedInstanceState);
        Bundle b = this.getArguments();
        if(b != null){
            String titulo = b.getString("titulo");
            PDFView pdfView = (PDFView) view.findViewById(R.id.pdfView);
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo1Categoria))){
                pdfView.fromAsset("algoritmia.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo2Categoria))){
                pdfView.fromAsset("puntonet.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo3Categoria))){
                pdfView.fromAsset("moviles.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo4Categoria))){
                pdfView.fromAsset("php.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo5Categoria))){
                pdfView.fromAsset("bd.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo6Categoria))){
                pdfView.fromAsset("java.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo7Categoria))){
                pdfView.fromAsset("3d.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo8Categoria))){
                pdfView.fromAsset("produccion.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo9Categoria))){
                pdfView.fromAsset("multimedia.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo10Categoria))){
                pdfView.fromAsset("videojuegos.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo11Categoria))){
                pdfView.fromAsset("hardening.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo12Categoria))){
                pdfView.fromAsset("redes.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo13Categoria))){
                pdfView.fromAsset("mapping.pdf").load();
            }
            if(titulo.equalsIgnoreCase(getString(R.string.txtTitulo14Categoria))){
                pdfView.fromAsset("emprendimiento.pdf").load();
            }
        }

    }
}
