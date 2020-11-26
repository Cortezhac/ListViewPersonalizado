package com.cortezhac.contactos;

import android.content.Intent;
import android.os.Bundle;

import com.cortezhac.contactos.model.ContactoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContactosActivity extends AppCompatActivity {
    private ListView listaContactos;
    private ContactoDAO admin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent agregar = new Intent(getApplicationContext(), AgregarContactoActivity.class);
                //startActivity(agregar);
                finish();
            }
        });
        admin = new ContactoDAO(getApplicationContext());
        listaContactos = findViewById(R.id.listaContactos);

        CutomContactosAdapter adapter = new CutomContactosAdapter(getApplicationContext(), admin.listarContactos());
        listaContactos.setAdapter(adapter);

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ContactosActivity.this, "Has hecho click en " + admin.listarContactos().get(i).getNombre() +
                        " " + admin.listarContactos().get(i).getApellido(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}