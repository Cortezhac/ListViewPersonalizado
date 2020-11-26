package com.cortezhac.contactos;

import android.content.Context;
import android.graphics.Color;
import android.media.session.PlaybackState;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cortezhac.contactos.data.Contactos;

import java.util.ArrayList;

public class CutomContactosAdapter extends BaseAdapter {
    private ArrayList<Contactos> listaContactos;
    private Context context;
    //Contructor de objeto que pide una lista y el contexto de la app
    public CutomContactosAdapter(Context context, ArrayList<Contactos> listaContactos){
        this.listaContactos = listaContactos;
        this.context = context;
    }
    // Estos 3 elemtos sirven para iterar cada elemento de la lista
    @Override
    public int getCount() {
        return listaContactos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        TextView nombre, telefono;
        if(view == null){
            view = LayoutInflater.from(this.context).inflate(R.layout.custom_list_view, null);
            // Binding o enlce entre java y XML
            imageView = view.findViewById(R.id.imageView);
            nombre = view.findViewById(R.id.txtNombre);
            telefono = view.findViewById(R.id.txtTelefono);
            // Acciones que se ejecutara sobre el custom layout
            imageView.setImageResource(R.drawable.ic_baseline_account_circle_24);
            imageView.setColorFilter(Color.BLACK);
            nombre.setText(this.listaContactos.get(i).getNombre());
            telefono.setText(this.listaContactos.get(i).getTelefono());
        }

        return view;
    }
}
