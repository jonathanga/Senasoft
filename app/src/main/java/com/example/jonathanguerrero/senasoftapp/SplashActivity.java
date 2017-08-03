package com.example.jonathanguerrero.senasoftapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jonathanguerrero.senasoftapp.gestiondatos.GsonResultadoParcer;
import com.example.jonathanguerrero.senasoftapp.gestiondatos.Resultado;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    //Fijar tiempo de espera del Splash
    private static final long SPLASH_SCREEN_DELAY = 4000;
    //Consumo JSON
    HttpURLConnection con;
    InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fijar orientacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Esconder title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ImageView splash1 = (ImageView) findViewById(R.id.logo1);
        splash1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.primera, 302, 135));
        ImageView splash2 = (ImageView) findViewById(R.id.logo2);
        splash2.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.sena, 95, 96));
        ImageView splash3 = (ImageView) findViewById(R.id.logo3);
        splash3.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.bienestar, 202, 86));
        //Simular la carga y en este punto aprovechar para consultar el WS
        try {
            new JsonTaskMain().
                    execute(new URL("http://cisweb.herokuapp.com/api/resultados_api/?format=json"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

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

    public class JsonTaskMain extends AsyncTask<URL, Void, Boolean> {
        List<Resultado> resultados = null;

        @Override
        protected Boolean doInBackground(URL... params) {
            try {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    // Establecer la conexión
                    con = (HttpURLConnection) params[0].openConnection();
                    con.setConnectTimeout(5000);
                    con.setReadTimeout(10000);

                    // Obtener el estado del recurso
                    int statusCode = con.getResponseCode();

                        if (statusCode != 200) {
                            //resultados = new ArrayList<>();
                            //resultados.add(new Resultado("Error", null, null, 0, 0, 0, 0));
                        } else {
                            // Parsear el flujo con formato JSON
                            in = new BufferedInputStream(con.getInputStream());
                            GsonResultadoParcer gsonResultadoParcer = new GsonResultadoParcer();
                            resultados = gsonResultadoParcer.leerFlujoJson(in);
                        }
                } else {
                    //resultados = new ArrayList<>();
                    //resultados.add(new Resultado("Error", null, null, 0, 0, 0, 0));
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if(con != null){
                con.disconnect();}
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean res) {
            /*
            Asignar los objetos de Json parseados al adaptador
             */
            if (resultados != null) {
                Resultado.deleteAll(Resultado.class);
                for (Resultado temp : resultados
                        ) {
                    temp.save();

                }
                resultados.clear();
                Toast.makeText(SplashActivity.this,getResources().getString(R.string.txtMsgConexion1),Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SplashActivity.this, "No se pudo descargar la información del servicio", Toast.LENGTH_SHORT).show();
            }
            //Iniciar la aplicacion
            Intent main = new Intent().setClass(SplashActivity.this, MainActivity.class);
            startActivity(main);
            //Cerrar el Splash para no poder regresar a el
            finish();

        }
    }

}
