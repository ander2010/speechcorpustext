package com.example.letal.speechcorpustext;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.net.Proxy.Type.HTTP;


/**
 * Clase Main3Activity es la clase que muestra como funciona de la aplicación y explica un poco acerca de los creadores de la APP.
 * @author megamind
 * @version  v1
 *
 */

public class Main3Activity extends AppCompatActivity  implements View.OnClickListener {
    Button boton;



    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesitaria para la actividad
     * @param  savedInstanceState
     *
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boton =findViewById(R.id.button);
        boton.setOnClickListener(this);








    }



    /**
     * Método sobreescrito generado a partir de la implementacion de  un View.OnClickListener y es para saber a que componente se dio clic
     * Este Método realiza el case para obtener cual es el elemento cliqueado y a que actividad se va a llamar.
     * @param   v
     *
     *
     */

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:composeEmail(new String[]{"andersanchez1987@gmail.com"},"La vida de PI");break;
            default:break;

    }

    }


    /**
     * Método composeEmail genera la información para que el usuario se comunique con el equipo de desarrollo a través de su correo personal
     * enviando un email a los creadores de la APP
     * @param  addresses,subject
     *
     *
     */

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
