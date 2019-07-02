package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo,editCurso,editCarrera;
    Button btnAgregar;
    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo=(EditText)findViewById(R.id.editCodigo);
        editCurso=(EditText)findViewById(R.id.editCurso);
        editCarrera=(EditText)findViewById(R.id.editCarrera);
       btnAgregar=(Button) findViewById(R.id.btnAgregar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);

       final DatosBD datosBD=new DatosBD(getApplicationContext());
           btnAgregar.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               datosBD.agregarCursos(editCodigo.getText().toString(),editCurso.getText().toString(),editCarrera.getText().toString());
                   Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
           }
       });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(),MainListado.class);
                startActivity(intento);
            }
        });
    }
    }

