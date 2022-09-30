package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.guia03.MainActivity.trabajadorRepository;

public class MostrarListaActivity extends AppCompatActivity {

    private ListView lstTrabajadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstTrabajadores = findViewById(R.id.lsvTrabajadores);

        lstTrabajadores.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trabajadorRepository.getAll()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}