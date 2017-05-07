package com.appprova.stanchese.appprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner continentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentes = (Spinner) findViewById(R.id.continentes);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Continentes,android.R.layout.simple_spinner_item);
        continentes.setAdapter(arrayAdapter);
    }

    public void listarPaises(View view) {

    }
}
