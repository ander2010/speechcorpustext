package com.example.letal.speechcorpustext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.letal.speechcorpustext.Objetos.FirebaseReference;
import com.example.letal.speechcorpustext.Objetos.corpus;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Clase Main4Activity ES la que muestra el boton para grabar y realiza el proceso de grabado de los datos personales del usuario
 * @author megamind
 * @version  v1
 *
 */

public class Main4Activity extends AppCompatActivity {

    private TextView txvResult;
    FirebaseDatabase database ;
    DatabaseReference tutorialmyRef ;
    Button butonedit,buttonenviar;
    ImageView imageView;
    EditText editar;

    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesitaria para la actividad
     * @param  savedInstanceState es un parametro de tipo Bundle que almacena infromación de la actividad
     *
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        butonedit=findViewById(R.id.editarButton);
        buttonenviar=findViewById(R.id.enviarButton);
        editar= findViewById(R.id.editTexto);
        imageView=findViewById(R.id.btnSpeakpersona);


        txvResult = (TextView) findViewById(R.id.txvResult);
        if (getIntent().hasExtra("dato1"))
        {

         //  txvResult.setText("Presione el botón MICRO, espere la señal y diganos su nombre,apellidos y a que entidad pertenece");
        }
//        Bundle parametros =;
//        if(parametros !=null){
//            String datos = parametros.getString("datos");
//            tv2.setText(datos);
//        }


//        txvResult = (TextView) findViewById(R.id.txvResult);
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


    /**
     * Método que guarda la información generada en la actividad en una base de datos de Firebase
     * @param  valor  Este es el texto especifico que se guarda en la base de datos de firebase
     *
     *
     *
     */
    public void llenarInformacion(String valor)
    {

        corpus coche = new corpus("Saludos",valor,"Suma");
        tutorialmyRef.child(FirebaseReference.DATOS_REFERENCE).push().setValue(coche);
    }



    /**
     * Método que envia el Intent ACTION_RECOGNIZE_SPEECH encargado de transcribir la voz a Texto
     * @param  view Este parametro te da acceso a la vista y especificamente funciona para saber el id que fue presionado
     *
     *
     *
     */
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

    /**
     * Método sobreescrito el cual se encarga de obtener el resultado de la transcripción y en caso de que todo
     * este correocto ejecutar el código que procede.
     * @param  requestCode,resultCode,data
     * El código de solicitud que pasaste a startActivityForResult().
     *       Un código de resultado especificado por la segunda actividad. Este código puede ser RESULT_OK si la operación se realizó correctamente o RESULT_CANCELED si el usuario canceló la operación o esta falló por algún motivo.
     *      Un Intent con la información del resultado.
     *
     *
     *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    //llenarInformacion(txvResult.getText().toString());

                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
//                    SharedPreferences prefs = getSharedPreferences("pref_visualizer",Context.MODE_PRIVATE);
                    boolean key=  pref.getBoolean("show_bass",true);
                    if (key) {
                        butonedit.setVisibility(View.VISIBLE);


                       // Toast.makeText(getApplicationContext(),"ESta chequeado",Toast.LENGTH_LONG).show();
                    }

                    else {

                        llenarInformacion(txvResult.getText().toString());
                        Toast.makeText(getApplicationContext(),"Se envio la Información Satisfactoriamente",Toast.LENGTH_LONG).show();

                    }

                }
                break;
        }
    }


    /**
     * Método sobreescrito para Inflar el Menu esta clase es fundamental porque es donde se infla el Menu
     * @param  menu es un parametro que representa un elemento de tipo Menu
     * @return  true
     *
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * Método sobreescrito para seleccionar el item que fue clickeado en el Menu  Este método dgenera un parametro item el cual tiene una propiedad getItemId
     * @param  item   es un parametro que representa un elemento de tipo MenuItem para conocer las características del presionado
     * @return  true
     *
     */
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
//            case R.id.editaSent:
////                Toast toast1 =
////                        Toast.makeText(getApplicationContext(),
////                                "Le dio al Menu", Toast.LENGTH_SHORT);
////
////                toast1.show();
//
//                // Abre una nueva Activity:
//                Intent myIntentw = new Intent(this, Principal.class);
//                startActivityForResult(myIntentw, 0);
//                return true;
        }
        return super.onOptionsItemSelected(item);

    }


    /**
     * Método que permite al usuario despues de grabar la información editarla
     * @param  view Este parametro te da acceso a la vista y especificamente funciona para saber el id que fue presionado
     *
     *
     *
     */
    public void EditarFrase(View view)
    {



        //   Toast.makeText(this, "Editar el texto", Toast.LENGTH_SHORT).show();
        editar.setVisibility(View.VISIBLE);
        editar.setText(txvResult.getText());
        txvResult.setVisibility(View.INVISIBLE);
        buttonenviar.setVisibility(View.VISIBLE);
        butonedit.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);



    }


    /**
     * Método que permite al usuario despues de grabar la información enviarla
     * @param  view Este parametro te da acceso a la vista y especificamente funciona para saber el id que fue presionado
     *
     *
     *
     */
    public void EnviarInfo(View view)
    {


        if (editar.getVisibility()==View.VISIBLE)
        {
            llenarInformacion(editar.getText().toString());
            editar.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
            buttonenviar.setVisibility(View.INVISIBLE);

            Toast.makeText(this, "Datos Editados Enviados Satisfactoriamente", Toast.LENGTH_SHORT).show();

        }

        else{

            llenarInformacion(txvResult.getText().toString());
            Toast.makeText(this, "Datos  Enviados Satisfactoriamente", Toast.LENGTH_SHORT).show();
        }

    }


}
