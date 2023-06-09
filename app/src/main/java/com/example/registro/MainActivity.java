package com.example.registro;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registro.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button enviar;
    TextView nombre ;
    TextView apellido ;
    TextView correo;
    TextView password;
    String pass = "1234";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

       //capturar elementos
       // enviar =(Button) findViewById(R.id.send);
       // nombre=(TextView) findViewById(R.id.nombre);
       // apellido=(TextView) findViewById(R.id.apellido);
       // password =(TextView) findViewById(R.id.contrasenia);
       // correo= (TextView) findViewById(R.id.email);
        nombre = binding.nombre;
        enviar = binding.send;
        apellido = binding.apellido;
        password = binding.contrasenia;
        correo = binding.email;
        //
        //binding.getNombre();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //toast
                Context context =getApplicationContext();
                CharSequence text="Datos vacios";
                CharSequence text2="error de password";
                CharSequence text3="solo se permiten letras, nombre y apellido no validos";
                CharSequence text4="formato de correo no valido";
                int duracion = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duracion);
                Toast toast2 = Toast.makeText(context,text2,duracion);
                Toast toast3 = Toast.makeText(context,text3,duracion);
                Toast toast4 = Toast.makeText(context,text4,duracion);


                //validamos campos vacios
                if ((!nombre.getText().toString().trim().equals("")) && (!apellido.getText().toString().trim().equals(""))
                        && (!correo.getText().toString().trim().equals(""))){
                    //patrones de validacion
                    Pattern pat = Pattern.compile("[a-zA-Z]{2,10}");
               //     Pattern pat2 = Pattern.compile("[0-9]*{2,10}");
                    Pattern patEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                    Matcher mat = pat.matcher(nombre.getText().toString());
                    Matcher mat2 = pat.matcher(apellido.getText().toString());
                    Matcher mat3 = patEmail.matcher(correo.getText().toString());
                    //validamos que nombre y apellido sean validos, letras mayusculas y minusculas
                    if(mat.matches() && mat2.matches()) {
                        //validamos formato de correo
                        if (mat3.matches()) {
                            //validamos contraseña
                            if (password.getText().toString().equals(pass)) {
                                //redireccionar a la activity 2
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("name", nombre.getText().toString());
                                intent.putExtra("surname", apellido.getText().toString());
                                intent.putExtra("email", correo.getText().toString());
                                startActivity(intent);
                             } else {toast2.show();}
                        } else {toast4.show();}
                    }else { toast3.show();}
                }else {toast.show();}
            }
        });

    }









}