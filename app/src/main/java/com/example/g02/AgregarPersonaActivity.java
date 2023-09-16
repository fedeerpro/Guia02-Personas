package com.example.g02;

import static com.example.g02.MainActivity.lstPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g02.clases.Persona;

import java.util.Currency;

public class AgregarPersonaActivity extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        edtNombre = findViewById(R.id.edtNombreed);
        edtApellido = findViewById(R.id.edtApellidoed);
        edtEdad = findViewById(R.id.edtEdaded);
        edtCorreo = findViewById(R.id.edtCorreoed);
        btnProcesar = findViewById(R.id.btnProcesarAdd);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtApellido.getText().length() == 0 || edtNombre.getText().length() == 0 || edtEdad.getText().length() == 0 || edtCorreo.getText().length() == 0){

                    Toast.makeText(AgregarPersonaActivity.this, "Los campos no pueden quedar vacios", Toast.LENGTH_SHORT).show();

                }else {
                    lstPersonas.add(new Persona(lstPersonas.size() + 1, edtNombre.getText().toString(),
                            edtApellido.getText().toString(), Integer.parseInt(edtEdad.getText().toString()),
                            edtCorreo.getText().toString()));
                    Toast.makeText(AgregarPersonaActivity.this, "Inserción exitosa", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}