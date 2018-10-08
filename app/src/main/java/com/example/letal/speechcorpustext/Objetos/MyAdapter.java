package com.example.letal.speechcorpustext.Objetos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.letal.speechcorpustext.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataSet;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.asignardatos(mDataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView;
        public ViewHolder(View  itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.idDato);
        }

        public void asignardatos(String s) {
            textView.setText(s);

        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public MyAdapter(ArrayList<String> myDataSet) {
        mDataSet = myDataSet;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView

}