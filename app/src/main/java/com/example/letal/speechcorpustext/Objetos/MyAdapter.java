package com.example.letal.speechcorpustext.Objetos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.letal.speechcorpustext.R;

import java.util.ArrayList;


/**
 * Esta clase se encarga de crear las Views necesarias para cada elemento del RecyclerView, además, está muy unida al ViewHolder.
 * @version v1
 * @author megamind
 * */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {
    private ArrayList<datos> mDataSet;
    private View.OnClickListener listener;
    private Context context;

    /**
     * El método OnCreateViewHolder inicializa el ViewHolder
     * @param parent,viewType
     * parent: ViewGroup en el que se agregará la nueva vista después de que se vincule a una posición de adaptador.
     * int viewType: el tipo de vista de la nueva vista.
     * */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);


//        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    /**
     * El método onBindViewHolder(ViewHolder viewholder, int position) se usa para configurar el contenido de las Views
     * @param holder,position
     *
     * holder: ViewHolder, que debe actualizarse para representar el contenido del elemento en la posición dada en el conjunto de datos.
     *
     * position int: la posición del elemento dentro del conjunto de datos del adaptador.
     *
     *
     * */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.asignardatos(mDataSet.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mDataSet.get(position).getMarca(),Toast.LENGTH_LONG).show();

            }
        });


    }
/**
 * El número total de elementos en este adaptador.
 *
 * */
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

//    public void setOnClickListener(View.OnClickListener listener)
//    {
//       this.listener=listener;
//    }
//
//    @Override
//    public void onClick(View v) {
//if (listener !=null){
//
//    listener.onClick(v);
//}
//    }

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons

    /**
     * La clase   ViewHolder funciona como  un cache de las vistas, pudiendo reutilizarlas en vez de crearlas nuevamente, se ha convertido
     * en un  patrón de codificación
     * */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView ;
        public TextView textView1 ;
        public LinearLayout linearLayout;
        public ViewHolder(View  itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.idDato);
            textView1 = itemView.findViewById(R.id.tv_item_number);
            linearLayout = itemView.findViewById(R.id.parent_layout);
        }

        /**
         * Este método se encarga de asignar a los texview especificos el contenido para que sea dibujado en el item y forme la lista
         * @param s  es el dato que se mostrará en los Texview que conforman la plantilla del ViewHolder
         * */
        public void asignardatos(datos s) {
            textView.setText(s.getMarca());
            textView1.setText(s.getMarca());

        }
    }

    /**
     * Este es nuestro constructor (puede variar según lo que queremos mostrar)
     * @param  contexto,myDataSet el contexto actual
     *
     * el valor no debe de ser nulo
     * myDataSet 	la lista de información
     * */
    public MyAdapter(Context contexto,ArrayList<datos> myDataSet) {

        context=contexto;
        mDataSet = myDataSet;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView

}