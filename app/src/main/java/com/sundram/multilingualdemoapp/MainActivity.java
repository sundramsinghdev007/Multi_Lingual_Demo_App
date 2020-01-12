package com.sundram.multilingualdemoapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerLanguage;
    Locale mylocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerLanguage=findViewById(R.id.spinner);
        ActivateSpinner();
    }

    private void ActivateSpinner() {

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position ==1)
                {
                    Toast.makeText(parent.getContext(),"You Have Selected Bangla",Toast.LENGTH_SHORT).show();
                    setLocale("bn");
                }
                if (position == 2)
                {
                    Toast.makeText(parent.getContext(),"You Have Selected Spanish",Toast.LENGTH_SHORT).show();
                    setLocale("es");
                }
                if (position==3)
                {
                    Toast.makeText(parent.getContext(),"You Have Selected English",Toast.LENGTH_SHORT).show();
                    setLocale("en");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setLocale(String lang)
    {
        mylocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics(); //get instance of selected item
        Configuration configuration=res.getConfiguration();
        configuration.locale = mylocale;
        res.updateConfiguration(configuration,dm);

        super.onRestart();
        Intent ii = new Intent(this,MainActivity.class);
        startActivity(ii);
        finish();
    }
}
