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
public class PublicoFragment extends Fragment {


    public PublicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publico, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        DocumentView documentView1 = (DocumentView) view.findViewById(R.id.document1Publico);
        documentView1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView1.setText(getResources().getString(R.string.txtTexto1Publico));

    }
}
