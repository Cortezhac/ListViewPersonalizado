package com.cortezhac.contactos.data;

public class Contactos {
    private int ID;
    private String nombre;
    private String apellido;
    private String telefono;

    public Contactos() {
    }

    public Contactos(int ID, String nombre, String numero) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = numero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
