package com.example.g02;

import static com.example.g02.MainActivity.lstPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.g02.clases.Persona;

public class MostrarListaActivity extends AppCompatActivity {

    private ListView lsvPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        lsvPersonas = findViewById(R.id.lsvPersona);

        ArrayAdapter<Persona> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lstPersonas);

        lsvPersonas.setAdapter(arrayAdapter);


        // Al hacer un click sostenido sobre un elemento de la lista se elimina el registro
        lsvPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MostrarListaActivity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        lstPersonas.remove(i);
                        Toast.makeText(MostrarListaActivity.this,"Registro borrado", Toast.LENGTH_SHORT).show();

                        lsvPersonas.setAdapter(arrayAdapter);
                    }
                });

                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                        }
                    });
                dialogo1.show();
                return true;
            }
        });
        //- Al hacer click sobre un elemento de la lista se debe poder editar
        lsvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MostrarListaActivity.this, EditarPersonas.class);
                intent.putExtra("Elemento", i);
                startActivity(intent);
                lsvPersonas.setAdapter(arrayAdapter);
                finish();
            }
        });

    }
}