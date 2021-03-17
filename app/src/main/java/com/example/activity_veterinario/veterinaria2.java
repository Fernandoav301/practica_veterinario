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
    Button anterior;
    TextView nombreuser;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinaria2);
        anterior = (Button)findViewById(R.id.anterior);
        nombreuser= (TextView)findViewById(R.id.nombre);
        leercredenciales();

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                // i.putExtra("json", "Los datos son"+name);
                startActivity(i);
            }
        });

    }

    private void leercredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        nombreuser.setText("Bienvenido a CATDOG :" + preferences.getString("user", ""))
        ;
    }
}