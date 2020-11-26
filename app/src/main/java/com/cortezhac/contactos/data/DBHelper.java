package com.cortezhac.contactos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String  DATABSE_NAME = "agenda.db";

    public DBHelper(Context context){
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ContactosContract.ContactosEntry.TABLE_NAME + " ( " +
                ContactosContract.ContactosEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                ContactosContract.ContactosEntry.COLUMN_NOMBRE + " TEXT NOT NULL," +
                ContactosContract.ContactosEntry.COLUMN_APELLIDO + " TEXT NOT NULL, " +
                ContactosContract.ContactosEntry.COLUMN_TELEFONO + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContactosContract.ContactosEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
