package com.example.enerdash.Data;

import com.example.enerdash.Modelos.ElectroModel;

import java.util.List;

public interface ElectroImgSource {
    public interface img {
        //public static final String EQUIPO = "Equipo";
        public static final String HORNO = "horno";
        public static final String LAP = "laptop";
        public static final String LAVADORA = "lavadora";
        public static final String  LICUADORA= "licuadora";
        public static final String REFRI = "refri";
        public static final String TV = "tv";
        public static final String  VENTILADOR = "ventilador";
    }

    List<ElectroModel> getAll(int count);
}
