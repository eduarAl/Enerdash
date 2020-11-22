package com.example.enerdash.Data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.helpers.FileHelper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

public class AppliancesFileSource implements ElectroImgSource{
    private final Gson parser;
    private final Context mContext;
    private static final String ELECTRO_FILE_NAME = "electrodomesticos.json";

    public AppliancesFileSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }

    public List<ElectroModel> getAll(int count) {
        String json = FileHelper.getJsonFromAssets(mContext, ELECTRO_FILE_NAME);
        ListResult listResult = parser.fromJson(json, ListResult.class);
        if(listResult == null) return null;
        return filterByCount(listResult.list, count);
    }

    private List<ElectroModel> filterByCount(@NonNull List<ElectroModel> originalList, int count) {
        if(count < 0) throw new IllegalArgumentException("Parametro count inválido");
        if(count == 0) return originalList;
        if(count >= originalList.size()) return originalList;
        return originalList.subList(0, count);
    }

    static class ListResult {
        @SerializedName("data")
        List<ElectroModel> list;

        public ListResult(List<ElectroModel> list) {
            this.list = list;
        }
    }
}
