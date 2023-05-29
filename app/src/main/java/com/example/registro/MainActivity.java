package com.example.registro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enviar;
    TextView nombre ;
    TextView apellido ;
    TextView correo;
    TextView password;
    String pass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //capturar elementos
        enviar =(Button) findViewById(R.id.send);
        nombre=(TextView) findViewById(R.id.nombre);
        apellido=(TextView) findViewById(R.id.apellido);
        password =(TextView) findViewById(R.id.contrasenia);
        correo= (TextView) findViewById(R.id.email);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //toast
                Context context =getApplicationContext();
                CharSequence text="Datos vacios";
                CharSequence text2="error de password";
                int duracion = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duracion);
                Toast toast2 = Toast.makeText(context,text2,duracion);

                if ((!nombre.getText().toString().trim().equals("")) && (!apellido.getText().toString().trim().equals("")) && (!correo.getText().toString().trim().equals(""))){
                 if(password.getText().toString().equals(pass)){
                     //redireccionar a la activity 2
                     Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                     intent.putExtra("name", nombre.getText().toString());
                     intent.putExtra("surname", apellido.getText().toString());
                     intent.putExtra("email", correo.getText().toString());
                     startActivity ( intent );
                 }
                     else{
                         toast2.show();
                     }
                    }
                else {
                    toast.show();
                }
            }
        });

    }









}