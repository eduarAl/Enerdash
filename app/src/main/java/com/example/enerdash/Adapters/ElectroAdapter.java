package com.example.enerdash.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enerdash.Modelos.ElectroModel;
import com.example.enerdash.R;
import com.example.enerdash.helpers.Events.ItemTapListener;

import java.util.List;

public class ElectroAdapter extends RecyclerView.Adapter<ElectroViewHolder> {

    @NonNull
    private List<ElectroModel> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    //pasamos parametros al adapter
    public ElectroAdapter(@NonNull List<ElectroModel> modelList, @Nullable ItemTapListener tapListener) {
        mModelList = modelList;
        mTapListener = tapListener;
    }

    public void updateList(List<ElectroModel> newList) {
        mModelList = newList;
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
}
