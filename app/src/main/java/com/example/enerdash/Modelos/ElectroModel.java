package com.example.enerdash.Modelos;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.VibrationAttributes;

public class ElectroModel implements Parcelable {

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

    protected ElectroModel(Parcel in) {
        Id = in.readInt();
        Nombre = in.readString();
        Imagen = in.readString();
        Vatios = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(Nombre);
        dest.writeString(Imagen);
        dest.writeDouble(Vatios);
    }

    public static final Parcelable.Creator<ElectroModel> CREATOR = new Parcelable.Creator<ElectroModel>() {
        @Override
        public ElectroModel createFromParcel(Parcel in) {
            return new ElectroModel(in);
        }

        @Override
        public ElectroModel[] newArray(int size) {
            return new ElectroModel[size];
        }
    };
}
