package com.example.enerdash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.enerdash.Adapters.ElectroAdapter;
import com.example.enerdash.Data.ElectroRepository;
import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.helpers.Events.ItemTapListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CatalogoActivity extends AppCompatActivity implements ItemTapListener {

    private static final String TAG = MainActivity.class.getName();

    private ElectroRepository mElectroRepository;
    private List<ElectroModel> mModelList;
    private ElectroAdapter mElectrosAdapter;
    private ViewGroup rootView;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_aparatos);
        setup();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void setup() {
        mElectroRepository = new ElectroRepository(getBaseContext());
        mModelList = new ArrayList<>();

        Intent startIntent = getIntent();
        if(startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        rootView = findViewById(R.id.ly_List);
        btnCalcular = findViewById(R.id.btn_acces);
        setupApplianceListView();

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.titulo_catalogo));
        }
    }

    private void setupApplianceListView() {
        RecyclerView rvPoints = findViewById(R.id.rvCatalogo);
        mElectrosAdapter = new ElectroAdapter(mModelList, this);
        rvPoints.setAdapter(mElectrosAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 3);
        rvPoints.setLayoutManager(layoutManager);
        rvPoints.setHasFixedSize(true);
    }

    private void loadData() {
        if(!mModelList.isEmpty()) {
            Log.d(TAG, "Ya existen valores en la lista");
            return;
        }
        if(mElectroRepository == null) {
            Log.e(TAG, "mPointsRepository no debería ser null");
            return;
        }
        mModelList = mElectroRepository.getAll();
        mElectrosAdapter.updateList(mModelList);
    }

    @Override
    public void onItemTap(View view, int position) {
        showMessageWithSelectedItem(position);
        navegation(position);
    }

    private void showMessageWithSelectedItem(int position) {
        if(mModelList == null) {
            Log.e(TAG, "invalid mModelList");
            return;
        }
        if(position > mModelList.size()) {
            Log.e(TAG, "invalid position");
            return;
        }

        ElectroModel selectedItemModel = mModelList.get(position);
        Snackbar.make(rootView,
                String.format(Locale.getDefault(),
                        "Has seleccionado %s", selectedItemModel.getNombre()
                ),
                Snackbar.LENGTH_LONG
        ).show();
    }

    private void navegation(int position) {
/*
        if(mModelList.get(position) ==null)
        {
            Log.e(TAG, "invalid mModelList");
            Snackbar.make(rootView, String.format(Locale.getDefault(),
                    "Debes seleccionar un electrodomestico"
            ), Snackbar.LENGTH_LONG).show();
            return;
        }*/

        final ElectroModel selectedItemModel = mModelList.get(position);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager frgManager = getSupportFragmentManager();
                ViewResultFragment frg = ViewResultFragment.newInstance(selectedItemModel);
                frg.show(frgManager, "frg_Vista_Result");
            }
        });
    }
}