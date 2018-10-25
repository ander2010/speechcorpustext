package com.example.letal.speechcorpustext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Principal extends AppCompatActivity implements View.OnClickListener{
    private CardView nostros,corpus,datos,listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nostros=(CardView) findViewById(R.id.nosotros);
        corpus=(CardView)findViewById(R.id.corpuse);
        datos=(CardView)findViewById(R.id.datosperso);
        listado=(CardView)findViewById(R.id.operacione);
        nostros.setOnClickListener(this);
        corpus.setOnClickListener(this);
        datos.setOnClickListener(this);
        listado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){

            case  R.id.nosotros:i=new Intent(this,Main2Activity.class);startActivity(i);
            break;
            case  R.id.corpuse:i=new Intent(this,MainActivity.class);startActivity(i);
            break;
            case  R.id.datosperso:i=new Intent(this,MainActivity.class);startActivity(i);break;
            case R.id.operacione:i=new Intent(this,Main2Activity.class);startActivity(i);break;
            default: break;
        }

    }
}
