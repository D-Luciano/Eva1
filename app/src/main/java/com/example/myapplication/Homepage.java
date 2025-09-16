package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    private RecyclerView recyclerTareas;
    private ProgressBar barraProgreso;
    private TextView textoPorcentaje;
    private Button botonAgregar;

    private List<Task> listaTareas = new ArrayList<>();
    private TaskAdapter adaptador;

    @Override
    protected void onCreate(Bundle estadoGuardado) {
        super.onCreate(estadoGuardado);
        setContentView(R.layout.home_page);

        recyclerTareas = findViewById(R.id.recycler_tareas);
        barraProgreso = findViewById(R.id.progressBar);
        textoPorcentaje = findViewById(R.id.txt_porcentaje);
        botonAgregar = findViewById(R.id.btn_agregar_tarea);

        adaptador = new TaskAdapter(listaTareas, this::actualizarProgreso);

        recyclerTareas.setLayoutManager(new LinearLayoutManager(this));
        recyclerTareas.setAdapter(adaptador);

        botonAgregar.setOnClickListener(vista -> mostrarDialogoAgregar());
    }

    private void mostrarDialogoAgregar() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
        constructor.setTitle("Nueva tarea");

        final EditText entrada = new EditText(this);
        entrada.setHint("Escribe la tarea");
        constructor.setView(entrada);

        constructor.setPositiveButton("Agregar", (dialogo, cual) -> {
            String titulo = entrada.getText().toString();
            if (!titulo.isEmpty()) {
                listaTareas.add(new Task(titulo));
                adaptador.notifyItemInserted(listaTareas.size() - 1);
                actualizarProgreso();
            }
        });

        constructor.setNegativeButton("Cancelar", null);
        constructor.show();
    }

    private void actualizarProgreso() {
        int total = listaTareas.size();
        int completadas = 0;
        for (Task tarea : listaTareas) {
            if (tarea.estaCompletada()) {
                completadas++;
            }
        }

        int porcentaje = total > 0 ? (completadas * 100 / total) : 0;
        barraProgreso.setProgress(porcentaje);
        textoPorcentaje.setText(porcentaje + "% completado");
    }
}
