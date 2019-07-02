package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatosBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "cursosdi.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_CURSOS = "CREATE TABLE CURSOS (CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public DatosBD(Context context) {
        super(context, NOMBRE_BD,null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CURSOS);
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    public void agregarCursos(String codigo, String curso, String carrera){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSER INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }
    }

    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM cursosdi.bd";
        Cursor registros = database.rawQuery(q,null);
        if (registros.moveToFirst()) {
            do {
                lista.add(registros.getString(0));
                lista.add(registros.getString(1));
                lista.add(registros.getString(2));
            } while (registros.moveToNext());
        }

        return lista;
    }


}