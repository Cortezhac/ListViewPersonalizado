package com.cortezhac.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cortezhac.contactos.data.Contactos;
import com.cortezhac.contactos.model.ContactoDAO;

public class AgregarContactoActivity extends AppCompatActivity {
    private ContactoDAO  admin;
    private Contactos nuevoContacto;
    private EditText id, nombre, apellido, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        admin = new ContactoDAO(getApplicationContext());
        id = findViewById(R.id.editID);
        nombre = findViewById(R.id.editNombre);
        apellido = findViewById(R.id.editApellido);
        telefono = findViewById(R.id.editTelefono);
    }

    public void guardar(View v){
        if(validar(id) && validar(nombre) && validar(telefono) && validar(apellido)){
            nuevoContacto = new Contactos();
            nuevoContacto.setID(Integer.parseInt(id.getText().toString()));
            nuevoContacto.setNombre(nombre.getText().toString());
            nuevoContacto.setApellido(apellido.getText().toString());
            nuevoContacto.setTelefono(telefono.getText().toString());
            if(admin.insertar(nuevoContacto)){
                Toast.makeText(this, "Contacto agregado", Toast.LENGTH_SHORT).show();
                Intent actividad = new Intent(getApplicationContext(), ContactosActivity.class);
                startActivity(actividad);
            }else{
                Toast.makeText(this, "Error llene los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void listar(View v){
        Intent actividad = new Intent(getApplicationContext(), ContactosActivity.class);
        startActivity(actividad);
    }

    public boolean validar(EditText campo){
        boolean estado = false;
        if(campo.getText().toString().length() > 0){
            estado = true;
        }

        return estado;
    }
}