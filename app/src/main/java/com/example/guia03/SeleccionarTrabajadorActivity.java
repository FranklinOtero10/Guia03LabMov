package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SeleccionarTrabajadorActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rbtTH, rbtTC;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_trabajador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rbtTH = findViewById(R.id.rbtTH);
        rbtTC = findViewById(R.id.rbtTC);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);

        //btTH.setOnClickListener(this);
        //btTC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSiguiente:{
                    if(!rbtTH.isChecked() && !rbtTC.isChecked()){
                        new AlertDialog.Builder(this).setTitle("¡Aviso!")
                                .setMessage("Debe seleccionar una opción")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).show();
                    } else {
                        // Continuar con el flujo
                        if(rbtTH.isChecked()){
                            // Llevar a trabajador hora
                            Intent intent = new Intent(this, TrabajadorHoraActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Llevar a trabajador tiempo completo
                            Intent intent1 = new Intent(this, TrabajadorTiempoCompletoActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
            }break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}