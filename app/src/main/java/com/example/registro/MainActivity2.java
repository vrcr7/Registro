package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String nombre;
    String apellido;
    String correo;
    TextView mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        nombre = intent.getStringExtra("name");
        apellido = intent.getStringExtra("surname");
        correo = intent.getStringExtra("email");
        mes = (TextView) findViewById(R.id.mensaje);

        mes.setText("el nombre es :"+nombre+" "+apellido+" "+correo);

    }



}