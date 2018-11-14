package com.example.letal.speechcorpustext;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
* Clase Principal que almacena un menu para acceder a cada una de las actividades
* @author megamind
 * @version  v7:28.0.0
 *
*/
public class Principal extends AppCompatActivity implements View.OnClickListener  {
    private CardView nostros,corpus,datos,listado;
    private static final String PROCESS_OK = "PROCESS_OK";
    private static final String PROCESS_ERROR = "PROCESS_ERROR";
    private ProgressDialog progressDialog;
    LinearLayout rl ;


    /**
     * Método sobreescrito para Inflar el Menu esta clase es fundamental porque es donde se infla el Menu
     * @param  menu
     * @return  true
     *
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our visualizer_menu layout to this menu */
        inflater.inflate(R.menu.visualizer_menu, menu);
        /* Return true so that the visualizer_menu is displayed in the Toolbar */
        return true;
    }

    /**
     * Método sobreescrito para seleccionar el item que fue clickeado en el Menu  Este método dgenera un parametro item el cual tiene una propiedad getItemId
     * @param  item
     * @return  true
     *
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesitaria para la actividad
     * @param  savedInstanceState
     *
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        progressDialog = new ProgressDialog(Principal.this);
        progressDialog.setMessage("Procesando....");
        progressDialog.setMax(100);
       rl = (LinearLayout)findViewById(R.id.linealayout);

//        final CheckBoxPreference checkboxPref = (CheckBoxPreference)  getSharedPreferences("pref_visualizer",Context.MODE_PRIVATE);
//        checkboxPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                Log.d("MyApp", "Pref " + preference.getKey() + " changed to " + newValue.toString());
//
//                String correo = preference.getKey();
//                if (correo=="false")
//                {
//                    rl.setBackgroundColor(Color.parseColor("#000000"));
//                    //Toast.makeText(this,"LLego hasta aca").show();
//                }
//
//                else{
//
//                    rl.setBackgroundColor(Color.parseColor("#ffffff"));
//                  //  Toast.makeText(this," No llego dfsdfsfLLego hasta aca",Toast.LENGTH_LONG).show();
//                }
//
//
//                return true;
//            }
//        });





//        SharedPreferences prefs =
//                getSharedPreferences("pref_visualizer",Context.MODE_PRIVATE);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(true);
        nostros=(CardView) findViewById(R.id.nosotros);
        corpus=(CardView)findViewById(R.id.corpuse);
        datos=(CardView)findViewById(R.id.datosperso);
        listado=(CardView)findViewById(R.id.operacione);
        nostros.setOnClickListener(this);
        corpus.setOnClickListener(this);
        datos.setOnClickListener(this);
        listado.setOnClickListener(this);






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

        Intent i;
        switch (v.getId()){

            case  R.id.nosotros:i=new Intent(this,Main3Activity.class);startActivity(i);
            break;
            case  R.id.corpuse:i=new Intent(this,MainActivity.class);startActivity(i);
            break;
            case  R.id.datosperso:i=new Intent(this,Main4Activity.class);
            i.putExtra("dato1","personal");

            startActivity(i);break;
            case R.id.operacione:i=new Intent(this,Main2Activity.class);startActivity(i);
                runProgressBar(v);
            break;
            default: break;
        }

    }





    /**
     * Método es utilizado para hacer correr un progressbar que se llama en segundo plano cuando se quiere cargar un listado
     * Este listado este progressbar se ejecuta en segundo plano usando un AsyncTask
     * @param  view
     *
     *
     */
    // public void runProgressBar(View view) {
    public void runProgressBar(View view) {

        final HardTask downloadTask = new HardTask(Principal.this);
        downloadTask.execute("some_param");

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                downloadTask.cancel(true);
            }
        });
    }



    /**
     * Clase HardTask extiende de AsyncTask y se implementa con el objetivo de realizar en segundo plano una actividad determinada
     * para que no afecte el flujo fundamental de la aplicación
     * @author megamind
     * @version  v1
     *
     *
     */

    private class HardTask extends AsyncTask<String, Integer, String> {

        private Context context;

        public HardTask(Context context) {
            this.context = context;
        }


        /**
         * Método para realizar las operaciones en background esta sobreescrito
         *
         * @param  params
         *
         *
         */
        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i <= 200; i++) {
                publishProgress(i);
                try {
                    // simulate hard work
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return PROCESS_ERROR;
                }
            }
            return PROCESS_OK;
        }
        /**
         * Método sobreescrito y lo que pasa antes de la ejecución
         *
         *
         *
         *
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        /**
         * Método sobreescrito y lo que pasa mientras se actualiza
         *
         *
         *
         *
         */

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            progressDialog.setProgress(progress[0]);
        }

        /**
         * Método sobreescrito y lo que pasa despues de la ejecución
         *
         *
         *
         *
         */
        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if (PROCESS_OK.equals(result)) {
                Toast.makeText(context, "Process OK " + result, Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(context, "Process ERROR " + result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
