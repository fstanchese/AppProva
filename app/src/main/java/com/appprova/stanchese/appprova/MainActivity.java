package com.appprova.stanchese.appprova;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StringInterface {
    private Handler handler = new Handler();
    private Spinner continentes;
    private ArrayList<Pais> lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentes = (Spinner) findViewById(R.id.continentes);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Continentes,android.R.layout.simple_spinner_item);
        continentes.setAdapter(arrayAdapter);


    }

    public void listarPaises(View view) {
        String continente = continentes.getSelectedItem().toString();
        StringRequester tarefa = new StringRequester(this, this);
        tarefa.execute("https://restcountries.eu/rest/v2/region/"+continente);
    }

    @Override
    public void depoisDownload(String paises) {
        this.lista = new ArrayList<Pais>();

        try {
            JSONArray root = new JSONArray(paises);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                String nome = item.getString("name");
                String capital = item.getString("capital");
                String area = item.getString("area");
                String populacao = item.getString("population");
                String bandeira = item.getString("flag");

                JSONArray itemJSONArray =  item.getJSONArray("currencies");
                JSONObject rec = itemJSONArray.getJSONObject(0);

                String codigo = rec.getString("code");
                String nomeMoeda = rec.getString("name");
                String simbolo = rec.getString("symbol");
                Moeda moeda = new Moeda(codigo,nomeMoeda,simbolo);

                Pais pais = new Pais(nome,capital,area,populacao,moeda,bandeira);

                this.lista.add(pais);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (lista != null) {
            ListaAdapterPais listaAdapterPais = new ListaAdapterPais(this,this.lista);

            ListView listView = (ListView)findViewById(R.id.listarPaises);
            listView.setAdapter(listaAdapterPais);
        }
    }
}
