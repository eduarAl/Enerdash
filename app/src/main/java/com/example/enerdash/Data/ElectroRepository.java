package com.example.enerdash.Data;

import android.content.Context;

import com.example.enerdash.Modelos.ElectroModel;

import java.util.List;

public class ElectroRepository {

    private final ElectroImgSource mSource;

    public ElectroRepository(Context context) {
        mSource = (ElectroImgSource) new AppliancesFileSource(context);
    }

    public List<ElectroModel> getAll() {
        return mSource.getAll(50);
    }
}
