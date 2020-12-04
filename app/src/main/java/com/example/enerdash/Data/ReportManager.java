package com.example.enerdash.Data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.enerdash.BuildConfig;
import com.example.enerdash.Modelos.HistoryItemModel;
import com.example.enerdash.Modelos.ListItemModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class ReportManager {
    private static final String HISTORY_PREF_NAME = "Report_prefs";
    private final SharedPreferences prefReport;
    Gson parser;

    public ReportManager(@NonNull Context context) {
        this.prefReport = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);
    }

    public boolean addItem(ListItemModel items){
        SharedPreferences.Editor editor = prefReport.edit();
        parser = new Gson();
        String guid = getRandomID().toString();

        String electProvided = parser.toJson(items); // Serializa el objeto historyItem como un Json (representación), y lo guarda en una variabe String.
        editor.putString(guid, electProvided);
        editor.apply();
        return true;
    }

    public List<ListItemModel> getAll(){
        Map<String, ?> itemsMap = prefReport.getAll();
        List<ListItemModel> historyList = new ArrayList<>();
        for (Object mapItem : itemsMap.values()){
            final ListItemModel itemModel = parser.fromJson(
                    mapItem.toString(),
                    ListItemModel.class
            );
            historyList.add(itemModel);
        }
        return historyList;
    }

    private UUID getRandomID(){
        UUID randomID = UUID.randomUUID();
        return randomID;
    }

    private String getPrefsName() {
        return String.format(
                Locale.getDefault(),
                "%s_%s",
                BuildConfig.APPLICATION_ID, HISTORY_PREF_NAME
        );
    }
}
