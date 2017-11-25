package com.example.kevin.peliculasapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by Kevin on 22/11/2017.
 */

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate ( savedInstanceState );
        getFragmentManager ().beginTransaction ().replace(android.R.id.content, new SettingsFragment()).commit ();
    }

    public static class SettingsFragment extends PreferenceFragment{
        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate ( savedInstanceState );
            addPreferencesFromResource ( R.xml.preferences );
        }
    }
}
