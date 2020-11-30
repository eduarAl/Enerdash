package com.example.enerdash.Modelos;

public class HistoryItemModel {
    int id;
    float tiempo;

    public HistoryItemModel(int id, float tiempo) {
        this.id = id;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
}
