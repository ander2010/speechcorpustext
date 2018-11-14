package com.example.letal.speechcorpustext;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.letal.speechcorpustext.Objetos.Coche;
import com.example.letal.speechcorpustext.Objetos.FirebaseReference;
import com.example.letal.speechcorpustext.Objetos.MyAdapter;
import com.example.letal.speechcorpustext.Objetos.corpus;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * Clase Main2Activity es la clase que muestra el listado del corpus que se ha subido a la nube.
 * @author megamind
 * @version  v1
 *
 */
public class Main2Activity extends AppCompatActivity {
    private ArrayList<Coche> mDataSet;
    FirebaseDatabase database ;
    DatabaseReference tutorialmyRef ;
    private ProgressBar progressBar;
    private static final String PROCESS_OK = "PROCESS_OK";
    private static final String PROCESS_ERROR = "PROCESS_ERROR";
    private ProgressDialog progressDialog;

    RecyclerView recycler;


    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesitaria para la actividad
     * @param  savedInstanceState
     *
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);
        mDataSet = new ArrayList<>();
        database = FirebaseDatabase.getInstance();



        tutorialmyRef = database.getReference(FirebaseReference.TUTORIAL_REFERENCE);
        DatabaseReference dbCielo = tutorialmyRef.child(FirebaseReference.COCHE_REFERENCE);

        dbCielo.addValueEventListener(new ValueEventListener() {
            /**
             *Método el cual le adiciona un escuchador que detecta los cambios ocurridos en los datos del listado almacenado en la nube
             * @param dataSnapshot
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterator<DataSnapshot>items= dataSnapshot.getChildren().iterator();
                final ArrayList<Coche> mdatace=  guardarinformacion(items);



                final MyAdapter myAdapter = new MyAdapter(getApplicationContext(),mdatace);
//                myAdapter.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                            Toast.makeText(getApplicationContext(),"Seleccion:",mdatace.get(recycler.getChildAdapterPosition(v)).getRueda()).show();
//                    }
//                });
                recycler.setAdapter(myAdapter);



//                corpus corpus = dataSnapshot.getValue(corpus.class);

            }


            /**
             *Método sobreescrito el cual se ejecuta cuando es cancelada la conexión a la nube
             * @param databaseError
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }

    /**
     * Este método permite interactuar en la generación del listado que va a ser mostrado se encarga de almacenar la información en un listado
     * @return ArrayList<Coche>
     * @param items
     * */

    public  ArrayList<Coche> guardarinformacion(Iterator<DataSnapshot>items)
    {
        while (items.hasNext())
        {

            DataSnapshot item= items.next();
            String descripcion,operacion,titulo;
            descripcion=item.child("descripcion").getValue().toString();
            operacion=item.child("operacion").getValue().toString();
            titulo=item.child("titulo").getValue().toString();
            Coche coches=new Coche(descripcion,1,1,titulo);
            mDataSet.add(coches);
            System.out.println(descripcion+" " + operacion +" " + titulo);


        }

        return mDataSet;
    }




}


