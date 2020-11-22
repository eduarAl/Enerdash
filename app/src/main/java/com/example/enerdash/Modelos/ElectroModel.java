package com.example.enerdash.Modelos;

public class ElectroModel {

       private String Nombre;
       private String DescripcionImagen;
       private String Imagen;
       private double Consumo;

    public ElectroModel(String nombre, String descripcionImagen, String imagen, double consumo) {
        Nombre = nombre;
        DescripcionImagen = descripcionImagen;
        Imagen = imagen;
        Consumo = consumo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcionImagen() {
        return DescripcionImagen;
    }

    public void setDescripcionImagen(String descripcionImagen) {
        DescripcionImagen = descripcionImagen;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public double getConsumo() {
        return Consumo;
    }

    public void setConsumo(double consumo) {
        Consumo = consumo;
    }
}
