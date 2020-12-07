package com.example.enerdash.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.example.enerdash.BuildConfig;
import com.example.enerdash.Modelos.HistoryItemModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class HistoryManager {
    private static final String HISTORY_PREF_NAME = "History_prefs";
    private final SharedPreferences prefHistorial;
    private final Gson parser;

    public HistoryManager(@NonNull Context context) {
        prefHistorial = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);
        parser = new Gson();
    }

    public boolean addHistoryItem(HistoryItemModel historyItem){
        if(historyItem == null) return false;
        if(TextUtils.isEmpty(String.valueOf(historyItem.getId()))) return false;
        if(TextUtils.isEmpty(String.valueOf(historyItem.getTiempo()))) return false;

        String guid = getRandomID().toString();
        SharedPreferences.Editor editor = prefHistorial.edit();

        String electProvided = parser.toJson(historyItem); // Serializa el objeto historyItem como un Json (representación), y lo guarda en una variabe String.
        editor.putString(guid, electProvided);
        editor.apply();
        return true;
    }

    public List<HistoryItemModel> getAll(){
        Map<String, ?> itemsMap = prefHistorial.getAll();
        List<HistoryItemModel> historyList = new ArrayList<>();
        for (Object mapItem : itemsMap.values()){
                final HistoryItemModel itemModel = parser.fromJson(
                        mapItem.toString(),
                        HistoryItemModel.class
                );
                historyList.add(itemModel);
        }
        return historyList;
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
