package com.example.enerdash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import com.example.enerdash.Data.ReportBuilder;
import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.Modelos.HistoryItemModel;
import com.example.enerdash.Modelos.ListItemGeneralModel;
import com.example.enerdash.Modelos.ListItemModel;
import com.example.enerdash.helpers.Events.ItemTapListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CatalogoActivity extends AppCompatActivity implements ItemTapListener, SearchView.OnQueryTextListener {

    private static final String TAG = MainActivity.class.getName();

    private ElectroRepository mElectroRepository;
    private List<ElectroModel> mModelList;
    private ElectroAdapter mElectrosAdapter;
    private ViewGroup rootView;
    private ElectroModel posicionElectro;
    private Button btnCalcular;
    private SearchView svSearch;
    private List<ListItemGeneralModel> itemGeneralModels;

    TextInputLayout tilMinUso;
    EditText etMinUso;
    HistoryItemModel historic;
    int idElectro;
    ListItemModel item;
    List<ListItemModel> listElec;

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
        tilMinUso = findViewById(R.id.til_minutosUso);
        svSearch = findViewById(R.id.sv_buscar);
        etMinUso = tilMinUso.getEditText();
        btnCalcular = findViewById(R.id.btn_calcular);

        setupApplianceListView();
        setupViewFromData();
        initListener();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.titulo_catalogo));
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
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
        posicionElectro = mModelList.get(position);
        idElectro = posicionElectro.getId();
    }

    private void calculate(){
        if(!validateFields()) {
            return;
        }
        ReportBuilder reportBuilder = new ReportBuilder();
        String kw, monto;


        historic = new HistoryItemModel(idElectro, Float.valueOf(etMinUso.getText().toString()));
        saveHistoryItem(historic);
        item = reportBuilder.calcularConsumoUnitario(posicionElectro, Float.valueOf(etMinUso.getText().toString()));
        DecimalFormat format = new DecimalFormat("0.00");
        kw = "Has consumido " + format.format(item.getKwConsumidos()) + " kWh/mes";
        monto = "Tu monto a pagar es de " + format.format(item.getMonto()) + " córdobas.";

        navigateToFragment(kw, monto);
    }

    private void navigateToFragment(String kw, String monto){
        FragmentManager frgManager = getSupportFragmentManager();
        ViewResultFragment frg = ViewResultFragment.newInstance(posicionElectro, kw, monto);
        frg.show(frgManager, "frg_Vista_Result");
    }

    private void saveHistoryItem(HistoryItemModel historyItem){
        HistoryManager register = new HistoryManager(getApplicationContext());
        register.addHistoryItem(historyItem);
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

    private boolean validateFields() {
        if(posicionElectro == null){
            showMessage("Favor seleccione un electrodoméstico.");
            return false;
        }
        if (etMinUso.getText() == null || TextUtils.isEmpty(etMinUso.getText().toString())) {
            showMessage("Favor ingresa los minutos que se usó el electrodoméstico.");
            return false;
        }
        showMessage("¡Electrodoméstico ingresado correctamente!");
        return true;
    }

    private void showMessage (String message){
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }

    //Métodos para buscar electrodoméstico
    private void initListener(){
        svSearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mElectrosAdapter.filter(newText);
        return false;
    }
}