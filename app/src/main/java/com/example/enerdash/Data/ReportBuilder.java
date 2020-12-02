package com.example.enerdash.Data;

import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.Modelos.HistoryItemModel;

import java.util.List;

public class ReportBuilder {
    AppliancesFileSource elect;
    HistoryManager electProvided;

    private void comparar(){
        List<ElectroModel> original = elect.getAll(50);
    }

}
