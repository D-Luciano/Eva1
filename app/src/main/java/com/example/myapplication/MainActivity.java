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

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button botonLogin;
    private Button botonSignUp;

    @Override
    protected void onCreate(Bundle estadoGuardado) {
        super.onCreate(estadoGuardado);
        setContentView(R.layout.activity_main);

        botonLogin = findViewById(R.id.btn_login);
        botonSignUp = findViewById(R.id.btn_signup);

        botonLogin.setOnClickListener(vista -> {
            Intent irALogin = new Intent(MainActivity.this, LoginPage.class);
            startActivity(irALogin);
        });

        botonSignUp.setOnClickListener(vista -> {
            Intent irARegistro = new Intent(MainActivity.this, SignInPage.class);
            startActivity(irARegistro);
        });
    }
}