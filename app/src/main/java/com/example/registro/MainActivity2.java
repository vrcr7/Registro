package com.example.registro;

import static com.example.registro.R.id.volver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    String nombre;
    String apellido;
    String correo;
    TextView mes;
    Button back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        nombre = intent.getStringExtra("name");
        apellido = intent.getStringExtra("surname");
        correo = intent.getStringExtra("email");
        back = (Button) findViewById(R.id.volver);
        mes = (TextView) findViewById(R.id.mensaje);

        mes.setText("el nombre es :"+nombre+" "+apellido+" "+correo);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //comprobacion
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                 startActivity ( intent );

            }
        });

    }



}