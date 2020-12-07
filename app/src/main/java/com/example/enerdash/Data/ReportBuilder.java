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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class ReportBuilder {
    private static final int MINHORA = 60;
    private static final double CARGO = 3.1817;

    ArrayList<ListItemGeneralModel> listItemGeneralModels;
    ListItemModel items;
    ListItemGeneralModel generalItems;
    List<HistoryItemModel> historyItemModel;
    List<ElectroModel> electroModel;
    HistoryItemModel historyItem;

    public ListItemModel calcularConsumoUnitario(ElectroModel model, float tiempo){
        float kwMes = 0;
        float monto = 0;

        float conversion = tiempo / MINHORA;
        kwMes = (float) ((model.getVatios() * conversion )/ 1000);
        monto = (float) (kwMes * CARGO);

        items = new ListItemModel(model.getId(), model.getNombre(), kwMes, monto);
        return items;
    }

    public ArrayList<ListItemGeneralModel> calcularConsumoGeneral(Context context){

        AppliancesFileSource data = new AppliancesFileSource(context);
        electroModel = data.getAll(38);
        float kwMes=0, monto=0;

        for(int i = 0; i < electroModel.size(); i++) {
            historyItemModel = ola(context);
            for(int x =0; x < historyItemModel.size();x++){
                if(historyItemModel.get(x).getId()==electroModel.get(i).getId()){
                    float conversion = historyItemModel.get(x).getId() / MINHORA;
                    kwMes = (float) (electroModel.get(i).getVatios() * conversion/ 1000);
                    monto = (float) (kwMes * CARGO);
                    generalItems = new ListItemGeneralModel(electroModel.get(i).getId(), electroModel.get(i).getNombre(), kwMes, monto);
                    listItemGeneralModels.add(generalItems);
                }
            }
        }
        return listItemGeneralModels;
    }

    private List<HistoryItemModel> ola(Context context){
        HistoryManager historyManager = new HistoryManager(context);
        historyItemModel =  historyManager.getAll();
        float suma = 0;
        for (int i = 0; i < historyItemModel.size(); i++){
            int val = historyItemModel.get(i).getId();
            for(int y = 0; y < historyItemModel.size();y++){
                if (val==historyItemModel.get(y).getId()){
                    suma+= historyItemModel.get(y).getTiempo();
                    historyItem = new HistoryItemModel(historyItemModel.get(y).getId(),suma);
                    historyItemModel.add(historyItem);
                }
            }
        }
        return historyItemModel;
    }


}
