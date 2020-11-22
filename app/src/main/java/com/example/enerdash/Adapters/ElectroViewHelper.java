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
                return R.drawable.refri2;
            case ElectroImgSource.img.TV:
                return R.drawable.tv;
            case ElectroImgSource.img.VENTILADOR:
                return R.drawable.ventilador;
            default:
                return R.drawable.logo_enerdash2;
        }
    }

}