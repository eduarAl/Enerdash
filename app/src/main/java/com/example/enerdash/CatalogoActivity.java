package com.example.enerdash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import com.example.enerdash.Adapters.ElectroAdapter;
import com.example.enerdash.Data.ElectroRepository;
import com.example.enerdash.Data.HistoryManager;
import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.helpers.Events.ItemTapListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
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
    private ElectroModel ElectroModel;

    TextInputLayout tilMinUso;
    EditText etMinUso;

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
        rootView = findViewById(R.id.ly_List);
        btnCalcular = findViewById(R.id.btn_calcular);

        setupApplianceListView();
        setupViewFromData();
        OnClickCalcular();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.titulo_catalogo));
        }
    }

    private void setupApplianceListView() {
        RecyclerView rvPoints = findViewById(R.id.rvCatalogo);
        mElectrosAdapter = new ElectroAdapter(mModelList, this);
        rvPoints.setAdapter(mElectrosAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 2);
        rvPoints.setLayoutManager(layoutManager);
        rvPoints.setHasFixedSize(true);
    }

    private void loadData() {
        if (!mModelList.isEmpty()) {
            Log.d(TAG, "Ya existen valores en la lista");
            return;
        }
        if (mElectroRepository == null) {
            Log.e(TAG, "mElectroRepository no debería ser null");
            return;
        }
        mModelList = mElectroRepository.getAll();
        mElectrosAdapter.updateList(mModelList);
    }

    @Override
    public void onItemTap(View view, int position) {
        showMessageWithSelectedItem(position);
        ElectroModel = mModelList.get(position);
    }

    private void OnClickCalcular() {
        //final int idElec = selectedItemModel.getId();
        //tilMinUso = findViewById(R.id.til_minutosUso);
        //etMinUso = tilMinUso.getEditText();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   navegationFragment();
               }
        });
    }

    private void navegationFragment(){
        if(ElectroModel == null){
            showMessage("Seleccione un electrodomestico");
            return;
        }
        if (etMinUso.getText() == null || TextUtils.isEmpty(etMinUso.getText().toString())) {
            showMessage("Favor ingresa los minutos que se usó el electrodoméstico...");
            return;
        }
        FragmentManager frgManager = getSupportFragmentManager();
        ViewResultFragment frg = ViewResultFragment.newInstance(ElectroModel);
        frg.show(frgManager, "frg_Vista_Result");
    }

    private void showMessageWithSelectedItem(int position) {
        if (mModelList == null) {
            Log.e(TAG, "invalid mModelList");
            return;
        }
        if (position > mModelList.size()) {
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

    private void setupViewFromData() {
        Intent startIntent = getIntent();
        if (startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
    }

    private void showMessage (String message){
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }
}