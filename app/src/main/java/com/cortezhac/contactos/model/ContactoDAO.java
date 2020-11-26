package com.cortezhac.contactos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cortezhac.contactos.data.Contactos;
import com.cortezhac.contactos.data.ContactosContract;
import com.cortezhac.contactos.data.DBHelper;

import java.util.ArrayList;

public class ContactoDAO {
    private DBHelper SQLite;
    private SQLiteDatabase db;
    public ContactoDAO(Context context){
        this.SQLite = new DBHelper(context);
    }

    public boolean insertar(Contactos contactos){
        this.db = this.SQLite.getConexion();
        boolean estado;
        try{
            ContentValues datos = new ContentValues();
            datos.put(ContactosContract.ContactosEntry.COLUMN_ID, contactos.getID());
            datos.put(ContactosContract.ContactosEntry.COLUMN_NOMBRE, contactos.getNombre());
            datos.put(ContactosContract.ContactosEntry.COLUMN_APELLIDO, contactos.getApellido());
            datos.put(ContactosContract.ContactosEntry.COLUMN_TELEFONO, contactos.getTelefono());
            int res = (int) db.insert(ContactosContract.ContactosEntry.TABLE_NAME,null,datos);
            if(res > 0){
                estado = true;
            }else{
                estado = false;
            }
        }catch (Exception ex){
            Log.i("Insertar", "Error" + ex);
            estado = false;
        }
        return estado;
    }

    public ArrayList<Contactos> listarContactos(){
        this.db = this.SQLite.getConexion();
        ArrayList<Contactos> listaContactos = new ArrayList<>();
        try{
            Cursor resultado = this.db.rawQuery("SELECT * FROM " + ContactosContract.ContactosEntry.TABLE_NAME, null);
            while(resultado.moveToNext()){
                Contactos contactos = new Contactos();
                contactos.setID(resultado.getInt(0));
                contactos.setNombre(resultado.getString(1));
                contactos.setApellido(resultado.getString(2));
                contactos.setTelefono(resultado.getString(3));
                listaContactos.add(contactos);
            }
        }catch (Exception ex){
            Log.i("Listar", "Error" + ex);
        }
        return listaContactos;
    }
}
