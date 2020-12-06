package com.example.enerdash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.enerdash.Adapters.ElectroViewHelper;
import com.example.enerdash.Modelos.ElectroModel;

public class ViewResultFragment extends DialogFragment {

    private static final String ARG_ELECTRO = "electro";
    private static final String ARG_KW = "kw";
    private static final String ARG_MONTO = "monto";
    private ElectroModel mElectroList;
    private String kw, monto;

    public ViewResultFragment() {
        // Required empty public constructor
    }

    public static ViewResultFragment newInstance(ElectroModel model, String kw, String monto) {
        ViewResultFragment fragment = new ViewResultFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ELECTRO, model);
        args.putString(ARG_KW, kw);
        args.putString(ARG_MONTO, monto);
        fragment.setArguments(args);
        fragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mElectroList = getArguments().getParcelable(ARG_ELECTRO);
            kw = getArguments().getString(ARG_KW);
            monto = getArguments().getString(ARG_MONTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view, mElectroList, kw, monto);
    }

    private void setup(View view, ElectroModel model, String kw, String monto){

        TextView tvName = view.findViewById(R.id.tv_message);
        TextView tvMonto = view.findViewById(R.id.tv_gastado);
        TextView tvConector = view.findViewById(R.id.tv_porTanto);
        ImageView IvImg = view.findViewById(R.id.iv_electro);

        TextView tvConsumido = view.findViewById(R.id.tv_consumido);

        tvName.setText(model.getNombre());
        IvImg.setImageResource(
                ElectroViewHelper.getResIdByImg(model.getImagen())
        );
        tvConsumido.setText(kw);
        tvConector.setText(getString(R.string.conector));
        tvMonto.setText(monto);

        Button btnOk = view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

}