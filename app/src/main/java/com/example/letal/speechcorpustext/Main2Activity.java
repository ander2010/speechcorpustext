package com.example.letal.speechcorpustext;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.letal.speechcorpustext.Objetos.datos;
import com.example.letal.speechcorpustext.Objetos.FirebaseReference;
import com.example.letal.speechcorpustext.Objetos.MyAdapter;
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
    private ArrayList<datos> mDataSet;
    FirebaseDatabase database ;
    DatabaseReference tutorialmyRef ;
    private ProgressBar progressBar;
    private static final String PROCESS_OK = "PROCESS_OK";
    private static final String PROCESS_ERROR = "PROCESS_ERROR";
    private ProgressDialog progressDialog;

    RecyclerView recycler;


    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesaria para la actividad
     * @param  savedInstanceState es un parámetro  de tipo Bundle que almacena infromación de la actividad
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
             * @param dataSnapshot El agente de escucha recibe una DataSnapshot que contiene los datos de la ubicación específica en el momento del evento. Si llamas a getValue() en una instantánea, se muestra la representación de los datos del objeto Java
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterator<DataSnapshot>items= dataSnapshot.getChildren().iterator();
                final ArrayList<datos> mdatace=  guardarinformacion(items);



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
             *Método sobreescrito el cual se  llama si se cancela la lectura.
             * @param databaseError  Este método recibe un objeto DatabaseError que indica por qué se produjo el error.
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }

    /**
     * Este método permite interactuar en la generación del listado que va a ser mostrado se encarga de almacenar la información en un listado
     * @return ArrayList<datos>
     * @param items Listado completo a mostrar en la lista de información
     * */

    public  ArrayList<datos> guardarinformacion(Iterator<DataSnapshot>items)
    {
        while (items.hasNext())
        {

            DataSnapshot item= items.next();
            String descripcion,operacion,titulo;
            descripcion=item.child("descripcion").getValue().toString();
            operacion=item.child("operacion").getValue().toString();
            titulo=item.child("titulo").getValue().toString();
            datos coches=new datos(descripcion,1,1,titulo);
            mDataSet.add(coches);
            System.out.println(descripcion+" " + operacion +" " + titulo);


        }

        return mDataSet;
    }




}


