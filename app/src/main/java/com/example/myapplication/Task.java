package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Task {
    private String titulo;
    private boolean completada;

    public Task(String titulo) {
        this.titulo = titulo;
        this.completada = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
