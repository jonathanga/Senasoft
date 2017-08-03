package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformacionFragment extends Fragment {


    public InformacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_informacion, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        DocumentView documentView1 = (DocumentView) view.findViewById(R.id.document1Informacion);
        documentView1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView1.setText(getResources().getString(R.string.txtTexto1Informacion));
        DocumentView documentView2 = (DocumentView) view.findViewById(R.id.document2Informacion);
        documentView2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView2.setText(getResources().getString(R.string.txtTexto2Informacion));
        DocumentView documentView3 = (DocumentView) view.findViewById(R.id.document3Informacion);
        documentView3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView3.setText(getResources().getString(R.string.txtTexto3Informacion));

    }
}
