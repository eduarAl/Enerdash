package com.example.enerdash.Data;

import android.content.SharedPreferences;

public class HistoryManager {
    private final SharedPreferences prefHistorial;

    public HistoryManager(SharedPreferences prefHistorial) {
        this.prefHistorial = prefHistorial;
    }
}
