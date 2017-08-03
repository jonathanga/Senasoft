package com.example.jonathanguerrero.senasoftapp.adaptadores;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonathanguerrero.senasoftapp.ListaResultadosFragment;
import com.example.jonathanguerrero.senasoftapp.R;
import com.example.jonathanguerrero.senasoftapp.ResultadoFragment;
import com.example.jonathanguerrero.senasoftapp.TabResultadosFragment;

/**
 * Created by jonathanguerrero on 14/04/17.
 */

public class CustomAndroidGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] string;
    private final int[] Imageid;
    private ResultadoFragment fragment;

    public CustomAndroidGridViewAdapter(Context mContext, String[] string, int[] imageid, ResultadoFragment fragment) {
        this.mContext = mContext;
        this.string = string;
        Imageid = imageid;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.gridview_custom_layout,null);
            TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.gridview_image);
            textView.setText(string[position]);

            imageView.setImageBitmap(decodeSampledBitmapFromResource(fragment.getResources(), Imageid[position], 80, 80));

            //imageView.setImageResource(Imageid[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("pos",position);

                    //ListaResultadosFragment listaResultadosFragment = new ListaResultadosFragment();
                    //listaResultadosFragment.setArguments(bundle);
                    TabResultadosFragment tabResultadosFragment = new TabResultadosFragment();
                    tabResultadosFragment.setArguments(bundle);

                    FragmentManager fragmentManager = fragment.getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    //fragmentTransaction.replace(R.id.mainLayout,listaResultadosFragment);
                    fragmentTransaction.replace(R.id.mainLayout,tabResultadosFragment);
                    fragmentTransaction.commit();
                    //Toast.makeText(parent.getContext(),""+position, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            grid = convertView;
        }

        return grid;    }

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
