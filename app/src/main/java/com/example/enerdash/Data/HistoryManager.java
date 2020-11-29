package com.example.enerdash.Data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.enerdash.BuildConfig;
import com.example.enerdash.CatalogoActivity;
import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.R;

import java.util.Locale;
import java.util.UUID;

public class HistoryManager extends AppCompatActivity {
    private static final String HISTORY_PREF_NAME = "History_prefs";
    public static final String ID_KEY = "ID";
    public static final String TIME_KEY = "TIME";
    public static final String PREF_ELECT_ID = "elect_id";
    public static final String PREF_ELECT_TIEMPO = "elect_tiempo";

    private final SharedPreferences prefHistorial;
    ElectroModel electroModel;

    public HistoryManager(@NonNull Context context) {
        prefHistorial = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);
    }

    public boolean setElect(@Nullable ElectroModel electrodomestico){
        if(electrodomestico == null) return false;
        if(electrodomestico.getId() == 0 || electrodomestico.getTiempoConsumido() <= 0)
            return false;

        SharedPreferences.Editor prefsEditor = prefHistorial.edit();
        prefsEditor.putInt(PREF_ELECT_ID, electrodomestico.getId());
        prefsEditor.putFloat(PREF_ELECT_TIEMPO, electrodomestico.getTiempoConsumido());
        prefsEditor.apply();
        return true;
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

    private UUID getRandomID(){
        UUID randomID = UUID.randomUUID();
        return randomID;
    }

    //When naming your shared preference files, you should use a name that's uniquely identifiable to your app
    private String getPrefsName() {
        return String.format(
                Locale.getDefault(),
                "%s_%s",
                BuildConfig.APPLICATION_ID, HISTORY_PREF_NAME
        );
    }
}
