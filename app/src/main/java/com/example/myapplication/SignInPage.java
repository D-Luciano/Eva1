package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class SignInPage extends AppCompatActivity {

    private EditText campoNombre;
    private EditText campoCorreo;
    private EditText campoContraseña;
    private EditText campoConfirmar;
    private Button botonRegistrarse;

    @Override
    protected void onCreate(Bundle estadoGuardado) {
        super.onCreate(estadoGuardado);
        setContentView(R.layout.signin_page);

        campoNombre = findViewById(R.id.itxt_nombre);
        campoCorreo = findViewById(R.id.itxt_correo);
        campoContraseña = findViewById(R.id.itxt_contraseña);
        campoConfirmar = findViewById(R.id.itxt_confcontra);
        botonRegistrarse = findViewById(R.id.btn_registrarse);

        botonRegistrarse.setOnClickListener(vista -> {
            String nombre = campoNombre.getText().toString();
            String correo = campoCorreo.getText().toString();
            String contraseña = campoContraseña.getText().toString();
            String confirmar = campoConfirmar.getText().toString();

            if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || confirmar.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else if (!contraseña.equals(confirmar)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí iría el registro real (Firebase, base de datos, etc.)
                // Por ahora, simplemente redirigimos a Homepage
                Intent irAHome = new Intent(SignInPage.this, Homepage.class);
                startActivity(irAHome);
                finish();
            }
        });
    }
}