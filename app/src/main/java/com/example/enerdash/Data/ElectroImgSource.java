package com.example.enerdash.Data;

import com.example.enerdash.Modelos.ElectroModel;

import java.util.List;

public interface ElectroImgSource {
    public interface img {
        public static final String EQUIPO = "parlante";
        public static final String MICROONDAS = "microondas";
        public static final String LAP = "laptop";
        public static final String LAVADORA = "lavadoraNegra";
        public static final String  LICUADORA= "licuadora";
        public static final String REFRI = "refri";
        public static final String TV = "tv";
        public static final String  CONSOLA = "ps3";
        public static final String  SERCADOR = "secadora";
        public static final String  PLANCHA = "plancha";
        public static final String ESCRITORIO = "escritorio";
        public static final String IMP_FOT= "imp_fot";
        public static final String FOT = "fot";
        public static final String INALAMBRICO = "inalambrico";
        public static final String LAMP_TUBO = "lamp_tubo";
        public static final String LAMP_CIR = "lamp_cir";
        public static final String BOMBILLA = "bombilla";
        public static final String BUJIA = "bujia";
        public static final String AIRE_VENTANA = "aire_ventana";
        public static final String AIRE_SPLIT = "aire_split";
        public static final String ABANICO_TECHO = "abanico_techo";
        public static final String VENTILADOR = "ventilador";
        public static final String MINICOMPONENTE = "minicomponente";
        public static final String RADIO = "radio";
        public static final String TEATRO = "teatro";
        public static final String DVD = "dvd";
        public static final String EXTRACTOR = "extractor";
        public static final String ARROCERA = "arrocera";
        public static final String SANDWICHERA = "sandwichera";
        public static final String TOS = "tos";
        public static final String ASADOR = "asador";
        public static final String HORNO = "horno";
        public static final String CAFETERA = "cafetera";
        public static final String PLANCHA_CABELLO = "plancha_cabello";
        public static final String CORTAR_CABELLO = "cortar_cabello";
        public static final String HIELO = "maquina_hielo";
        public static final String ROCKONOLA = "rockonola";
        public static final String ABANICO = "abanico";


    }

    List<ElectroModel> getAll(int count);
}
