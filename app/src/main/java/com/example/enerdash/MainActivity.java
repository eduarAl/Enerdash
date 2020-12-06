package com.example.enerdash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.enerdash.Adapters.ListItemGeneralAdapter;
import com.example.enerdash.Data.UserConfig;
import com.example.enerdash.Modelos.ListItemGeneralModel;
import com.example.enerdash.Modelos.ListItemModel;
import com.example.enerdash.Modelos.UserModel;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Constantes
    private static final String TAG = MainActivity.class.getName();
    private ListView items;
    private ListItemGeneralAdapter adapter;
    private ArrayList<ListItemGeneralModel> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        items = findViewById(R.id.LV_Main);
        adapter = new ListItemGeneralAdapter(this, getAll());
        items.setAdapter(adapter);

        Button btn = findViewById(R.id.fab_regCon);

        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#CDA67F")));
        mPieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#FED70E")));

        mPieChart.startAnimation();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCatalogo();
            }
        });
    }

    private ArrayList<ListItemGeneralModel> getAll(){
        ArrayList<ListItemGeneralModel> item = new ArrayList<>();
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        item.add(new ListItemGeneralModel(1,"Licuadora",90,90));
        return item;
    }

    private void navigateToCatalogo() {
        Intent intent = new Intent(this, CatalogoActivity.class);
        startActivity(intent);
    }
}