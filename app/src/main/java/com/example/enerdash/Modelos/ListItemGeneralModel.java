package com.example.enerdash.Modelos;

public class ListItemGeneralModel {
    private int id;
    private String nombre;
    private float kwConsumidos;
    private float monto;

    public ListItemGeneralModel(int id, String nombre, float kwConsumidos, float monto) {
        this.id = id;
        this.nombre = nombre;
        this.kwConsumidos = kwConsumidos;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getKwConsumidos() {
        return kwConsumidos;
    }

    public void setKwConsumidos(float kwConsumidos) {
        this.kwConsumidos = kwConsumidos;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
