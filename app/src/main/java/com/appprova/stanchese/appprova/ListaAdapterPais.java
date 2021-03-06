package com.appprova.stanchese.appprova;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.Request;
import okhttp3.Response;

public class ListaAdapterPais extends ArrayAdapter<Pais> {

    private Context context;
    private ArrayList<Pais> lista;

    public ListaAdapterPais(Context context, ArrayList<Pais> lista ) {
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.pais,null,true);

        }

        Pais paisPosicao = this.lista.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.pais_bandeira);
        Picasso.with(context).load("http://flagpedia.net/data/flags/normal/"+paisPosicao.getBandeira().toLowerCase()+".png").into(imageView);

        TextView pais_nome = (TextView) convertView.findViewById(R.id.pais_nome);
        TextView pais_capital = (TextView) convertView.findViewById(R.id.pais_capital);
        TextView pais_area = (TextView) convertView.findViewById(R.id.pais_area);
        TextView pais_populacao = (TextView) convertView.findViewById(R.id.pais_populacao);
        TextView pais_moeda = (TextView) convertView.findViewById(R.id.pais_moeda);

        pais_nome.setText(paisPosicao.getNome());
        pais_capital.setText(paisPosicao.getCapital());
        pais_area.setText(paisPosicao.getArea()+ " Km2");
        pais_populacao.setText(paisPosicao.getPopulacao()+ " habitantes");
        pais_moeda.setText(paisPosicao.getMoeda().getNome());

        return convertView;
    }

}
