package com.example.g02;

import static com.example.g02.MainActivity.lstPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g02.clases.Persona;

import java.util.ArrayList;

public class EditarPersonas extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    Button btnProcesaredi;
    private ArrayList<Persona> lsvPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_personas);
        edtNombre = findViewById(R.id.edtNombreed);
        edtApellido = findViewById(R.id.edtApellidoed);
        edtEdad = findViewById(R.id.edtEdaded);
        edtCorreo = findViewById(R.id.edtCorreoed);
        btnProcesaredi = findViewById(R.id.btnProcesarEdi);
       Bundle bundle;

        bundle = getIntent().getExtras();
        int _id = bundle.getInt("Elemento");
            edtNombre.setText(lstPersonas.get(_id).getNombrePersona());
            edtApellido.setText(lstPersonas.get(_id).getApellidoPersona());
            edtEdad.setText(lstPersonas.get(_id).getEdadPersona() + "");
            edtCorreo.setText(lstPersonas.get(_id).getCorreoPersona());

        btnProcesaredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtApellido.getText().length() == 0 || edtNombre.getText().length() == 0 || edtEdad.getText().length() == 0 || edtCorreo.getText().length() == 0){

                    Toast.makeText(EditarPersonas.this, "Los campos no pueden quedar vacios", Toast.LENGTH_SHORT).show();

                }else {
                    int edad = Integer.parseInt(edtEdad.getText().toString());
                    lstPersonas.get(_id).setNombrePersona(edtNombre.getText().toString());
                    lstPersonas.get(_id).setApellidoPersona(edtApellido.getText().toString());
                    lstPersonas.get(_id).setEdadPersona(Integer.parseInt(edtEdad.getText().toString()));
                    lstPersonas.get(_id).setCorreoPersona(edtCorreo.getText().toString());
                    Toast.makeText(EditarPersonas.this, "Modificacion exitosa", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
   }

}