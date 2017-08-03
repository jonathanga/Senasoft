package com.example.jonathanguerrero.senasoftapp;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LugarFragment extends Fragment{



    public LugarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lugar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        DocumentView documentView1 = (DocumentView) view.findViewById(R.id.document1Lugar);
        documentView1.getDocumentLayoutParams().setTextAlignment(TextAlignment.CENTER);
        documentView1.getDocumentLayoutParams().setTextColor(R.color.colorVerdeSENA);
        documentView1.getDocumentLayoutParams().setTextSize(20);
        documentView1.setText(getResources().getString(R.string.txtTexto1Lugar));
        DocumentView documentView2 = (DocumentView) view.findViewById(R.id.document2Lugar);
        documentView2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView2.setText(getResources().getString(R.string.txtTexto2Lugar));
        ImageView imageView1 = (ImageView) view.findViewById(R.id.cartago1);
        imageView1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.cartago1, 645, 300));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.cartago2);
        imageView2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.cartago2, 645, 300));


    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


}
