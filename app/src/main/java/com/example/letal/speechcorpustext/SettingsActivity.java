package com.example.letal.speechcorpustext;

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Clase SettingsActivity que almacena información sobre el fragmento de las preferencias
 * @author megamind
 * @version  v7:28.0.0
 *
 */

public class SettingsActivity extends AppCompatActivity {


    /**
     * Método sobreescrito para la creación de la actividad el método oncreate es donde se inicializa la información necesitaria para la actividad
     * @param  savedInstanceState es un parametro de tipo Bundle que almacena infromación de la actividad
     *
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Método sobreescrito para seleccionar el item que fue clickeado en el Menu  Este método dgenera un parametro item el cual tiene una propiedad getItemId
     * @param  item  es un parametro que representa un elemento de tipo MenuItem para conocer las características del presionado
     * @return  true
     *
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // When the home button is pressed, take the user back to the VisualizerActivity
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}