package com.example.activity_veterinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class veterinaria3 extends AppCompatActivity {
    Button continuar, regresar;
    EditText pregunta1, pregunta2, pregunta3;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinaria3);
        continuar = (Button) findViewById(R.id.Continuar);
        regresar = (Button) findViewById(R.id.regresar);
        pregunta1= (EditText)findViewById(R.id.pregunta1);
        pregunta2= (EditText)findViewById(R.id.pregunta2);
        pregunta3= (EditText)findViewById(R.id.pregunta3);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), veterinaria4.class);
                startActivity(i);
                GuardarCredenciales(pregunta1.getText().toString(),pregunta2.getText().toString(),pregunta3.getText().toString());
                startActivity(i);
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), veterinaria2.class);
                startActivity(i);
            }
        });
    }

    private void GuardarCredenciales(String p1, String p2, String p3) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("pregunta1", p1);
        editor.putString("pregunta2", p2);
        editor.putString("pregunta3", p3);
        editor.commit();

    }

}

