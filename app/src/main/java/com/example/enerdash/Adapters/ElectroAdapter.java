package com.example.enerdash.Adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.R;
import com.example.enerdash.helpers.Events.ItemTapListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectroAdapter extends RecyclerView.Adapter<ElectroViewHolder> {
    @NonNull
    private List<ElectroModel> mModelList, originalModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    //pasamos parametros al adapter
    public ElectroAdapter(@NonNull List<ElectroModel> modelList, @Nullable ItemTapListener tapListener) {
        mModelList = modelList;
        mTapListener = tapListener;
    }

    public void updateList(List<ElectroModel> newList) {
        mModelList = newList;
        originalModelList = new ArrayList<>(); //almacena el listado original, ya que mModelList cambia durante la búsqueda
        originalModelList.addAll(newList);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //inflamos cada item con su respectiva vista.
    public ElectroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_electrodomestico, parent, false);
        ElectroViewHolder viewHolder = new ElectroViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ElectroViewHolder holder, int position) {
        ElectroModel currentModel = mModelList.get(position);
        holder.ivImg.setImageResource(
                ElectroViewHelper.getResIdByImg(currentModel.getImagen())
        );
        holder.tvName.setText(currentModel.getNombre());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void filter(String consulta){

        if(consulta.length() == 0){
            mModelList.clear();
            mModelList.addAll(originalModelList);
        }
        else{
            //Para dispositivos con Android 8 o superiores
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mModelList.clear();
                List<ElectroModel> collect = originalModelList.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(consulta))
                        .collect(Collectors.toList());

                mModelList.addAll(collect);
            }
            else{
                mModelList.clear();
                for (ElectroModel i : originalModelList) {
                    if(i.getNombre().toLowerCase().contains(consulta)){
                        mModelList.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
