package com.example.activity_veterinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button iniciar, salir;
    EditText user, pass;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar = (Button)findViewById(R.id.iniciar);
        salir= (Button)findViewById(R.id.salir);
        user= (EditText)findViewById(R.id.edit_user);
        pass= (EditText)findViewById(R.id.edit_pass);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),veterinaria2.class);

                startActivity(i);
            }
        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),veterinaria2.class);
                GuardarCredenciales(user.getText().toString(),pass.getText().toString());
                startActivity(i);


            }
        });
    }
    private void GuardarCredenciales(String nombre, String password) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user", nombre);
        editor.putString("pass", password);
        editor.commit();

    }

}
