package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.guia03.MainActivity.trabajadorRepository;

import com.example.guia03.Model.TrabajadorHoraModel;

public class TrabajadorHoraActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtIDTH, edtNombreTH, edtApellidoTH, edtValorTH, edtHorasTH;
    private Button btnAgregarTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_hora);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtIDTH = findViewById(R.id.edtIDTH);
        edtNombreTH = findViewById(R.id.edtNombreTH);
        edtApellidoTH = findViewById(R.id.edtApellidoTH);
        edtValorTH = findViewById(R.id.edtValorTH);
        edtHorasTH = findViewById(R.id.edtHorasTH);

        btnAgregarTH = findViewById(R.id.btnAgregarTH);
        btnAgregarTH.setOnClickListener(this);
    }

    private void agregar(String codigo, String nombre, String apellido, int nh, float vh) {
        TrabajadorHoraModel tm = new TrabajadorHoraModel(codigo, nombre, apellido, nh, vh);

        trabajadorRepository.add(tm);
        confirmacionRegistro();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgregarTH:
                if (validarCampos()) {
                    agregar(edtIDTH.getText().toString(), edtNombreTH.getText().toString(), edtApellidoTH.getText().toString(),
                            Integer.parseInt(edtHorasTH.getText().toString()), Float.parseFloat(edtValorTH.getText().toString()));
                }
                break;
        }
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
        String id = edtIDTH.getText().toString();
        String nom = edtNombreTH.getText().toString();
        String ape = edtApellidoTH.getText().toString();
        String val = edtValorTH.getText().toString();
        String hor = edtHorasTH.getText().toString();

        if (id.isEmpty()) {
            edtIDTH.setError("Este campo no puede estar vacio");
            return false;
        }else if(nom.isEmpty()){
            edtNombreTH.setError("Este campo no puede estar vacio");
            return false;
        }else if(ape.isEmpty()){
            edtApellidoTH.setError("Este campo no puede estar vacio");
            return false;
        }else if(val.isEmpty()){
            edtValorTH.setError("Este campo no puede estar vacio");
            return false;
        }else if(hor.isEmpty()){
            edtHorasTH.setError("Este campo no puede estar vacio");
            return false;
        }else{
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