package com.example.letal.speechcorpustext;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.letal.speechcorpustext.Objetos.Coche;
import com.example.letal.speechcorpustext.Objetos.FirebaseReference;
import com.example.letal.speechcorpustext.Objetos.corpus;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView txvResult;
    FirebaseDatabase database ;
     DatabaseReference tutorialmyRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txvResult = (TextView) findViewById(R.id.txvResult);
        database = FirebaseDatabase.getInstance();
        tutorialmyRef = database.getReference(FirebaseReference.TUTORIAL_REFERENCE);



        //        if (txvResult.getText() != "" || txvResult.getText() != null)
//
//        {


//        texto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        }





    }

    public void llenarInformacion(String valor)
    {

        corpus coche = new corpus("Saludos",valor,"Suma");
        tutorialmyRef.child(FirebaseReference.COCHE_REFERENCE).push().setValue(coche);
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    llenarInformacion(txvResult.getText().toString());
                }
                break;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {

            case R.id.listadoSen:
//                Toast toast1 =
//                        Toast.makeText(getApplicationContext(),
//                                "Le dio al Menu", Toast.LENGTH_SHORT);
//
//                toast1.show();

                // Abre una nueva Activity:
                Intent myIntent = new Intent(this, Main2Activity.class);
                startActivityForResult(myIntent, 0);
                return true;
            case R.id.editaSent:
//                Toast toast1 =
//                        Toast.makeText(getApplicationContext(),
//                                "Le dio al Menu", Toast.LENGTH_SHORT);
//
//                toast1.show();

                // Abre una nueva Activity:
                Intent myIntentw = new Intent(this, Principal.class);
                startActivityForResult(myIntentw, 0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
