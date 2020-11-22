package com.example.enerdash.Adapters;

import androidx.annotation.DrawableRes;

import com.example.enerdash.Data.ElectroImgSource;
import com.example.enerdash.R;

public class ElectroViewHelper {

    @DrawableRes
    public static int getResIdByImg(String Imagen) {
        switch(Imagen) {
            case ElectroImgSource.img.HORNO:
                return R.drawable.hornomicro;
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
            case ElectroImgSource.img.VENTILADOR:
                return R.drawable.ventilador;
            case ElectroImgSource.img.EQUIPO:
                return R.drawable.equipo;
            case ElectroImgSource.img.CONSOLA:
                return R.drawable.ps3;
            case ElectroImgSource.img.SERCADOR:
                return R.drawable.secador_de_pelo;
            case ElectroImgSource.img.PLANCHA:
                return R.drawable.plancha;
            default:
                return R.drawable.enerdash_logo2;
        }
    }

}