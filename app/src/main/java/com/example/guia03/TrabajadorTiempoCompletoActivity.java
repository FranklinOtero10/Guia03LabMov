package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.guia03.MainActivity.trabajadorRepository;

import com.example.guia03.Model.TrabajadorTiempoCompletoModel;

public class TrabajadorTiempoCompletoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtIDTTC, edtNombreTTC, edtApellidoTTC, edtSalarioTTC;
    private Button btnAgregarTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_tiempo_completo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtIDTTC = findViewById(R.id.edtIDTTC);
        edtNombreTTC = findViewById(R.id.edtNombreTTC);
        edtApellidoTTC = findViewById(R.id.edtApellidoTTC);
        edtSalarioTTC = findViewById(R.id.edtSalarioTTC);

        btnAgregarTC = findViewById(R.id.btnAgregarTC);
        btnAgregarTC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarTC:
                if (validarCampos()){
                    agregar(edtIDTTC.getText().toString(),edtNombreTTC.getText().toString(),
                            edtApellidoTTC.getText().toString(), Float.parseFloat(edtSalarioTTC.getText().toString()));
                }
                break;
        }

    }

    private void agregar(String codigo, String nombre, String apellido, float salario) {
        TrabajadorTiempoCompletoModel tc = new TrabajadorTiempoCompletoModel(codigo, nombre, apellido, salario);

        trabajadorRepository.add(tc);
        confirmacionRegistro();
    }

    public void confirmacionRegistro() {
        new AlertDialog.Builder(this).setTitle("¡Registrado!").setMessage("Registro con éxito")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
    }

    public boolean validarCampos() {
        String id = edtIDTTC.getText().toString();
        String nom = edtNombreTTC.getText().toString();
        String ape = edtApellidoTTC.getText().toString();
        String sal = edtSalarioTTC.getText().toString();

        if (id.isEmpty()) {
            edtIDTTC.setError("Este campo no puede estar vacio");
            return false;
        } else if (nom.isEmpty()) {
            edtNombreTTC.setError("Este campo no puede estar vacio");
            return false;
        } else if (ape.isEmpty()) {
            edtApellidoTTC.setError("Este campo no puede estar vacio");
            return false;
        } else if (sal.isEmpty()) {
            edtSalarioTTC.setError("Este campo no puede estar vacio");
            return false;
        } else {
            return true;
        }
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