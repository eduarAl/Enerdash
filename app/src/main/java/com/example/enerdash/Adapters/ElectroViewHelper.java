package com.example.enerdash.Adapters;

import androidx.annotation.DrawableRes;

import com.example.enerdash.Data.ElectroImgSource;
import com.example.enerdash.R;

public class ElectroViewHelper {

    @DrawableRes
    public static int getResIdByImg(String Imagen) {
        switch(Imagen) {
            case ElectroImgSource.img.MICROONDAS:
                return R.drawable.microondas;
            case ElectroImgSource.img.LAP:
                return R.drawable.lap;
            case ElectroImgSource.img.LAVADORA:
                return R.drawable.lavadora;
            case ElectroImgSource.img.LICUADORA:
                return R.drawable.licuadora;
            case ElectroImgSource.img.REFRI:
                return R.drawable.refri;
            case ElectroImgSource.img.TV:
                return R.drawable.tv;
            case ElectroImgSource.img.EQUIPO:
                return R.drawable.equipo;
            case ElectroImgSource.img.CONSOLA:
                return R.drawable.ps3;
            case ElectroImgSource.img.SERCADOR:
                return R.drawable.secador_de_pelo;
            case ElectroImgSource.img.PLANCHA:
                return R.drawable.plancha;
            case ElectroImgSource.img.ESCRITORIO:
                return R.drawable.computadora_escritorio;
            case ElectroImgSource.img.IMP_FOT:
                return R.drawable.impresora_fotocopiadora;
            case ElectroImgSource.img.FOT:
                return R.drawable.fotocopiadora_mesa;
            case ElectroImgSource.img.INALAMBRICO:
                return R.drawable.tel_inalambrico;
            case ElectroImgSource.img.LAMP_TUBO:
                return R.drawable.lamp_tubo;
            case ElectroImgSource.img.LAMP_CIR:
                return R.drawable.lamp_circular;
            case ElectroImgSource.img.BOMBILLA:
                return R.drawable.bombilla_ahorrativa;
            case ElectroImgSource.img.BUJIA:
                return R.drawable.bujia;
            case ElectroImgSource.img.AIRE_VENTANA:
                return R.drawable.aireacondicionado_ventana;
            case ElectroImgSource.img.AIRE_SPLIT:
                return R.drawable.aireacondicionado_split;
            case ElectroImgSource.img.ABANICO_TECHO:
                return R.drawable.abanico_techo;
            case ElectroImgSource.img.VENTILADOR:
                return R.drawable.ventilador_vertical;
            case ElectroImgSource.img.MINICOMPONENTE:
                return R.drawable.minicomponente_sharp;
            case ElectroImgSource.img.RADIO:
                return R.drawable.radiograbadora;
            case ElectroImgSource.img.TEATRO:
                return R.drawable.teatro_en_casa;
            case ElectroImgSource.img.DVD:
                return R.drawable.dvd;
            case ElectroImgSource.img.EXTRACTOR:
                return R.drawable.extractor_jugo;
            case ElectroImgSource.img.ARROCERA:
                return R.drawable.arrocera;
            case ElectroImgSource.img.SANDWICHERA:
                return R.drawable.sandwichera;
            case ElectroImgSource.img.TOS:
                return R.drawable.tostadora;
            case ElectroImgSource.img.ASADOR:
                return R.drawable.asador_electrico;
            case ElectroImgSource.img.HORNO:
                return R.drawable.horno;
            case ElectroImgSource.img.CAFETERA:
                return R.drawable.cafetera;
            case ElectroImgSource.img.PLANCHA_CABELLO:
                return R.drawable.plancha_cabello;
            case ElectroImgSource.img.CORTAR_CABELLO:
                return R.drawable.maquina_cortar_cabello;
            case ElectroImgSource.img.HIELO:
                return R.drawable.maquina_hielos;
            case ElectroImgSource.img.ROCKONOLA:
                return R.drawable.rockonola;
            case ElectroImgSource.img.ABANICO:
                return R.drawable.abanico;
            default:
                return R.drawable.enerdash_logo2;
        }
    }

}