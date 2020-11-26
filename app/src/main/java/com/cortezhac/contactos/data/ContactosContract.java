package com.cortezhac.contactos.data;

import android.provider.BaseColumns;

public  class ContactosContract {
    public ContactosContract() { }
    // Contiene las constantes de la tabla a utilizar
    public static class ContactosEntry implements BaseColumns {
        public static final String TABLE_NAME = "contactos";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_APELLIDO = "apellido";
        public static final String COLUMN_TELEFONO = "telefono";
    }
}
