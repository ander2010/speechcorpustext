package com.example.letal.speechcorpustext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

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

public class Main2Activity extends AppCompatActivity {
    private ArrayList<String> mDataSet;
    FirebaseDatabase database ;
    DatabaseReference tutorialmyRef ;

    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mDataSet = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        tutorialmyRef = database.getReference(FirebaseReference.TUTORIAL_REFERENCE);
        DatabaseReference dbCielo = tutorialmyRef.child(FirebaseReference.COCHE_REFERENCE);



        dbCielo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot>items= dataSnapshot.getChildren().iterator();

                while (items.hasNext())
                {

                    DataSnapshot item= items.next();
                    String descripcion,operacion,titulo;
                    descripcion=item.child("descripcion").getValue().toString();
                    operacion=item.child("operacion").getValue().toString();
                    titulo=item.child("titulo").getValue().toString();
                    mDataSet.add("Dato #" + descripcion + "     "+ operacion + " " +titulo );
                    System.out.println(descripcion+" " + operacion +" " + titulo);
                    MyAdapter myAdapter = new MyAdapter(mDataSet);
                    recycler.setAdapter(myAdapter);
                }
//                corpus corpus = dataSnapshot.getValue(corpus.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }
}
