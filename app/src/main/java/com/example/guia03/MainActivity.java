package com.example.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guia03.Model.TrabajadorModel;
import com.example.guia03.Repository.TrabajadorRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TrabajadorRepository trabajadorRepository;

    private Button btnAgregarTrabajadorPrin, btnMostrarLisPrin, btnAcercaDePrin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Agregar la orientacion de la pantalla con codigo java
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        trabajadorRepository = new TrabajadorRepository();

        btnAgregarTrabajadorPrin = findViewById(R.id.btnAgregarTrabajadorPrin);
        btnAgregarTrabajadorPrin.setOnClickListener(this);
        btnMostrarLisPrin = findViewById(R.id.btnMostrarLisPrin);
        btnMostrarLisPrin.setOnClickListener(this);
        btnAcercaDePrin = findViewById(R.id.btnAcercaDePrin);
        btnAcercaDePrin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarTrabajadorPrin:
                Intent intent = new Intent(this, SeleccionarTrabajadorActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrarLisPrin:
                if (trabajadorRepository.getAll().isEmpty()){
                    Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent1 = new Intent(this, MostrarListaActivity.class);
                    startActivity(intent1);
                }
                break;
            case R.id.btnAcercaDePrin:
                Intent intent2 = new Intent(this, AcercaDeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}