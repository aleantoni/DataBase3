package com.example.database;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainListado extends AppCompatActivity {
ListView lv;
ArrayList<String> list;
ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_main);
        lv = (ListView)findViewById(R.id.list);
        DatosBD db = new DatosBD(getApplicationContext());
        list = db.llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adaptador);



    }
}
