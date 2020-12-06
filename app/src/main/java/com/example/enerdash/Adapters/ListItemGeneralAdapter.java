package com.example.enerdash.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.enerdash.Modelos.ListItemGeneralModel;
import com.example.enerdash.Modelos.ListItemModel;
import com.example.enerdash.R;

import java.util.ArrayList;
import java.util.List;

public class ListItemGeneralAdapter extends BaseAdapter {
    Context context;
    ArrayList<ListItemGeneralModel> listItemGeneral;

    public ListItemGeneralAdapter(Context context, ArrayList<ListItemGeneralModel> listItemGeneral) {
        this.context = context;
        this.listItemGeneral = listItemGeneral;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return listItemGeneral.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ListItemGeneralModel item = (ListItemGeneralModel) getItem(position);

        v = LayoutInflater.from(context).inflate(R.layout.item_top, null);

        TextView name, consumo, monto;
        name = v.findViewById(R.id.tv_nombre);
        consumo = v.findViewById(R.id.tv_consumoWt);
        monto = v.findViewById(R.id.tv_monto);

        name.setText(item.getNombre());
        consumo.setText(String.valueOf(item.getKwConsumidos()) + " kWh/Mes");
        monto.setText(String.valueOf(item.getMonto())+ " Córdobas");
        return v;
    }
}
