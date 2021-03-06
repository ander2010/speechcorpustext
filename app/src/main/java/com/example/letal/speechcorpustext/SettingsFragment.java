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

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Clase SettingsFragment que carga el xml que tiene que cargar un fragmento
 * @author megamind
 * @version  v1
 *
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    // COMPLETED (2) Create a class called SettingsFragment that extends PreferenceFragmentCompat

    /**
     * Método sobreescrito para la creación de la actividad el método onCreatePreferences es donde se inicializa la información necesitaria para cargar el  fragmento
     * @param  bundle,s
     *
     * bundle: si el fragmento se está recreando desde un estado guardado anterior, este es el estado.
     *
     * Cadena s: si no es nulo, este fragmento de preferencia debe estar enraizado en la Pantalla de Preferencia con esta clave.
     *
     */
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        // COMPLETED (5) In SettingsFragment's onCreatePreferences method add the preference file using the
        // addPreferencesFromResource method

        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer




        SharedPreferences.OnSharedPreferenceChangeListener spChanged = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                // If the buy schedule has changed, cancel and recreate the alarms.
                if (key.equals("show_bass")) {
                    try {

                        if (sharedPreferences.getBoolean(key,true))
                        {
                            Toast.makeText(getContext(),"LLego aca y es show bass",Toast.LENGTH_LONG).show();
                        }else
                        {

                            Toast.makeText(getContext(),"LLego aca y nuca llegara aca ",Toast.LENGTH_LONG).show();
                        }




//                        persistence.setLastBuyTime(0);
//                        BuyScheduler.setAlarm(getActivity().getApplicationContext());
                    } catch (Exception e) {
                        //
                    }
                }else{

                    Toast.makeText(getContext(),"LLego aca y nuca llegara aca ",Toast.LENGTH_LONG).show();

                }
            }
        };

        PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).registerOnSharedPreferenceChangeListener(spChanged);


        addPreferencesFromResource(R.xml.pref_visualizer);
    }

}