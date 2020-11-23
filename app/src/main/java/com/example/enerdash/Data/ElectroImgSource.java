package com.example.enerdash.Data;

import com.example.enerdash.Modelos.ElectroModel;

import java.util.List;

public interface ElectroImgSource {
    public interface img {
        public static final String EQUIPO = "parlante";
        public static final String HORNO = "horno";
        public static final String LAP = "laptop";
        public static final String LAVADORA = "lavadoraNegra";
        public static final String  LICUADORA= "licuadora";
        public static final String REFRI = "refri";
        public static final String TV = "tv";
        public static final String  VENTILADOR = "ventilador";
        public static final String  CONSOLA = "ps3";
        public static final String  SERCADOR = "secadora";
        public static final String  PLANCHA = "plancha";

    }

    List<ElectroModel> getAll(int count);
}
