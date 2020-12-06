package com.example.enerdash.Data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.enerdash.BuildConfig;
import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.Modelos.HistoryItemModel;
import com.example.enerdash.Modelos.ListItemGeneralModel;
import com.example.enerdash.Modelos.ListItemModel;
import com.google.gson.Gson;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class ReportBuilder {
    private static final int MINHORA = 60;
    private static final double CARGO = 3.1817;

    List<ListItemModel> listItemModels;
    List<ListItemGeneralModel> listItemGeneralModels;
    //ReportManager manager;
    ListItemModel items;
    ListItemGeneralModel generalItems;


    public ListItemModel calcularConsumoUnitario(ElectroModel model, float tiempo){
        float kwMes = 0;
        float monto = 0;

        float conversion = tiempo / MINHORA;
        kwMes = (float) ((model.getVatios() * conversion )/ 1000);
        monto = (float) (kwMes * CARGO);

        items = new ListItemModel(model.getId(), model.getNombre(), kwMes, monto);
        return items;
    }

    public List<ListItemGeneralModel> calcularConsumoGeneral(ElectroModel model, Context context) {
        HistoryManager manager = new HistoryManager(context);
        float tiempo = 0, kwMes, monto;

        List<HistoryItemModel> lista = manager.getAll();

        for(int i = 0; i <= lista.size(); i++){
            if(items.getId() == lista.get(i).getId()){
                tiempo =+ lista.get(i).getTiempo();
            }
        }
        float conversion = tiempo / MINHORA;
        kwMes = (float) ((model.getVatios() * conversion)/ 1000);
        monto = (float) (kwMes * CARGO);

        generalItems = new ListItemGeneralModel(model.getId(), model.getNombre(), kwMes, monto);
        listItemGeneralModels.add(generalItems);
        return listItemGeneralModels;
    }
}
