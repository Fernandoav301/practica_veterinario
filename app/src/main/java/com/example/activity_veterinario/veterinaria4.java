package com.example.activity_veterinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class veterinaria4 extends AppCompatActivity {
    Button Finalizar;
    TextView informacion;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinaria4);
        Finalizar = (Button)findViewById(R.id.Finalizar);
        informacion= (TextView)findViewById(R.id.datos);
        leercredenciales();


        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                // i.putExtra("json", "Los datos son"+name);
                startActivity(i);
            }
        });

    }

    private void leercredenciales() {
        preferences=getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        informacion.setText("Estimado: " +preferences.getString("user", "")+" se ha confirmado la solicitud para tu mascota: " +preferences.getString( "pregunta1"," ")+" de la raza: "+preferences.getString( "pregunta2"," ")+" y de edad: "+preferences.getString( "pregunta3"," ")+" a la cual le realizaremos un: "+preferences.getString( "baño"," "));
    }
}