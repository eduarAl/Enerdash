package com.example.enerdash.Modelos;

public class ElectroModel {
    private int Id;
    private String Nombre;
    private String Imagen;
    private double Vatios;
    private double TiempoConsumido;
    private double KwConsumido;
    private double Monto;

    public ElectroModel(int id, String nombre, String imagen, double vatios, double tiempoConsumido, double kwConsumido, double monto) {
        Id = id;
        Nombre = nombre;
        Imagen = imagen;
        Vatios = vatios;
        TiempoConsumido = tiempoConsumido;
        KwConsumido = kwConsumido;
        Monto = monto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public double getVatios() {
        return Vatios;
    }

    public void setVatios(double vatios) {
        Vatios = vatios;
    }

    public double getTiempoConsumido() {
        return TiempoConsumido;
    }

    public void setTiempoConsumido(double tiempoConsumido) {
        TiempoConsumido = tiempoConsumido;
    }

    public double getKwConsumido() {
        return KwConsumido;
    }

    public void setKwConsumido(double kwConsumido) {
        KwConsumido = kwConsumido;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }
}
