package com.example.enerdash.Data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enerdash.CatalogoActivity;
import com.example.enerdash.R;

public class HistoryManager extends AppCompatActivity {
    public static final String ID_KEY = "ID";
    public static final String TIME_KEY = "TIME";
    private final SharedPreferences prefHistorial;

    public HistoryManager(SharedPreferences prefHistorial) {
        this.prefHistorial = prefHistorial;
    }

    private void setUp() {
        Intent startIntent = getIntent(); //retorna la intencion que ha empezado la actividad
        if(startIntent == null){
            Toast.makeText(
                    this,
                    R.string.error_start_intent,
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        //Asignación de correspondencia con los datos pasados de la pantalla anterior con el Bundle
        String minUso = startIntent.getStringExtra(TIME_KEY);
        String idEl = startIntent.getStringExtra(ID_KEY);


    }
}
