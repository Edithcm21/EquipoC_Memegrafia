package com.example.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ViewHolder> {
    private List<List_Meme> mData;
    private LayoutInflater mInflater;
    private Context context;
    final List_Adapter.OnItemClikListener listener;

    public interface OnItemClikListener {
        void onItemClik(List_Meme item);
    }

    public List_Adapter(List<List_Meme> itemList, Context context, List_Adapter.OnItemClikListener listener){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;
        this.listener=listener;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public List_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=mInflater.inflate(R.layout.list_memes, null);
        return new List_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final List_Adapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<List_Meme> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombrememe, descripcion;

        ViewHolder(View itemView){
            super(itemView);
            imagen=itemView.findViewById(R.id.imagen);
            nombrememe=itemView.findViewById(R.id.nombrememe);
            descripcion=itemView.findViewById(R.id.descripcion);
        }

        void bindData(final List_Meme item){
            imagen.setImageResource(item.getImagen());
            nombrememe.setText(item.getNombre());
            descripcion.setText(item.getDescripcion());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClik(item);
                }
            });
        }
    }
}
