package com.example.enerdash.Modelos;

public class ElectroModel {

       private int Id;
       private String Nombre;
       private String Imagen;
       private double Vatios;

    public ElectroModel(int id, String nombre, String imagen, double vatios) {
        Id = id;
        Nombre = nombre;
        Imagen = imagen;
        Vatios = vatios;
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
}
