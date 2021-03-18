package com.example.activity_veterinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class veterinaria2 extends AppCompatActivity {
    Button anterior, baño, corte;
    TextView nombreuser;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinaria2);
        anterior = (Button) findViewById(R.id.anterior);
        baño = (Button) findViewById(R.id.baño);
        corte = (Button) findViewById(R.id.Corte);
        nombreuser = (TextView) findViewById(R.id.nombre);
        leercredenciales();
        baño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), veterinaria3.class);
                startActivity(i);
                GuardarCredenciales("Baño");

            }
        });

        corte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), veterinaria3.class);
                GuardarCredenciales("Corte");
                startActivity(i);
            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void leercredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        nombreuser.setText("Bienvenido a CATDOG :" + preferences.getString("user", ""));
    }


    private void GuardarCredenciales(String boton1) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("baño", boton1);
        editor.putString("corte", boton1);
        editor.commit();

    }

}