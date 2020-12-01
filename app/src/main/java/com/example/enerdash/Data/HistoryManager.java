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
import com.example.enerdash.Modelos.HistoryItemModel;
import com.example.enerdash.R;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class HistoryManager {
    private static final String HISTORY_PREF_NAME = "History_prefs";
    private final SharedPreferences prefHistorial;

    public HistoryManager(@NonNull Context context) {
        prefHistorial = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);
    }

    public boolean addHistoryItem(HistoryItemModel historyItem){
        if(historyItem == null) return false;
        if(TextUtils.isEmpty(String.valueOf(historyItem.getId()))) return false;
        if(TextUtils.isEmpty(String.valueOf(historyItem.getTiempo()))) return false;

        String guid = getRandomID().toString();
        SharedPreferences.Editor editor = prefHistorial.edit();
        Gson parser = new Gson();

        String electProvided = parser.toJson(historyItem); // Serializa el objeto historyItem como un Json (representación), y lo guarda en una variabe String.
        editor.putString(guid, electProvided);
        editor.apply();
        return true;
    }

    public Map obtenerTodo(){
        Map<String, ?> all = prefHistorial.getAll();
        return all;
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
