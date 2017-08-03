package com.example.jonathanguerrero.senasoftapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

import java.util.List;

/**
 * Created by jonathanguerrero on 11/04/17.
 */

public class AdaptadorCategoria extends RecyclerView.Adapter<AdaptadorCategoria.CategoriaViewHolder>{

    private List<Categoria> categoriaList;
    private CategoryFragment categoryFragment;

    public AdaptadorCategoria(List<Categoria> categoriaList,CategoryFragment fragment) {
        this.categoriaList = categoriaList;
        this.categoryFragment = fragment;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        CategoriaViewHolder categoriaViewHolder = new CategoriaViewHolder(itemView,categoryFragment);
        return categoriaViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder holder, int position) {
        Categoria categoriaTemp = categoriaList.get(position);
        holder.bindCategory(categoriaTemp);

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }


    public static class CategoriaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageCategoria;
        private TextView textTitulo;
        private DocumentView textResumen;
        private CardView cardView;
        private CategoryFragment fragment;

        public CategoriaViewHolder(View itemView,CategoryFragment fragment) {
            super(itemView);
            imageCategoria = (ImageView) itemView.findViewById(R.id.iconCategory);
            textTitulo = (TextView) itemView.findViewById(R.id.titleCategory);
            textResumen = (DocumentView) itemView.findViewById(R.id.textCategory);
            cardView = (CardView) itemView.findViewById(R.id.cardCategoriaDoc);
            this.fragment = fragment;
        }
        public void bindCategory(final Categoria categoria){
            imageCategoria.setImageBitmap(decodeSampledBitmapFromResource(fragment.getResources(), categoria.getIcono(), 100, 120));
            //imageCategoria.setImageResource(categoria.getIcono());
            textTitulo.setText(categoria.getTitulo());
            textResumen.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            textResumen.setText(categoria.getResumen());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("titulo",categoria.getTitulo().toString());

                    PdfFragment pdfFragment = new PdfFragment();
                    pdfFragment.setArguments(bundle);

                    FragmentManager fragmentManager = fragment.getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.mainLayout,pdfFragment);
                    fragmentTransaction.commit();

                }
            });
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
}
