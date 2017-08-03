package com.example.jonathanguerrero.senasoftapp.gestiondatos;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathanguerrero on 14/04/17.
 */

public class GsonResultadoParcer {
    public List<Resultado> leerFlujoJson(InputStream in) throws IOException {
        // Nueva instancia de la clase Gson
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<Resultado> resultados = new ArrayList<>();

        // Iniciar el array
        reader.beginArray();

        while (reader.hasNext()) {
            // Lectura de objetos
            Resultado animal = gson.fromJson(reader, Resultado.class);
            resultados.add(animal);
        }


        reader.endArray();
        reader.close();
        return resultados;
    }

}
