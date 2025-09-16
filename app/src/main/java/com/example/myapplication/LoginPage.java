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

public class LoginPage extends AppCompatActivity {

    private EditText campoCorreo;
    private EditText campoContraseña;
    private Button botonIngresar;

    @Override
    protected void onCreate(Bundle estadoGuardado) {
        super.onCreate(estadoGuardado);
        setContentView(R.layout.login_page);

        campoCorreo = findViewById(R.id.editTextEmail);
        campoContraseña = findViewById(R.id.editTextPassword);
        botonIngresar = findViewById(R.id.btn_ingresar);

        botonIngresar.setOnClickListener(vista -> {
            String correo = campoCorreo.getText().toString();
            String contraseña = campoContraseña.getText().toString();

            if (correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí iría la validación real (Firebase, base de datos, etc.)
                // Por ahora, simplemente redirigimos a Homepage
                Intent irAHome = new Intent(LoginPage.this, Homepage.class);
                startActivity(irAHome);
                finish();
            }
        });
    }
}
