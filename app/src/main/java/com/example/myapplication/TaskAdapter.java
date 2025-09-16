package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TareaViewHolder> {

    private List<Task> listaTareas;
    private Runnable alCambiarEstado;

    public TaskAdapter(List<Task> listaTareas, Runnable alCambiarEstado) {
        this.listaTareas = listaTareas;
        this.alCambiarEstado = alCambiarEstado;
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public TareaViewHolder(View vista) {
            super(vista);
            checkBox = vista.findViewById(R.id.checkbox_tarea);
        }
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup padre, int tipoVista) {
        View vista = LayoutInflater.from(padre.getContext())
                .inflate(R.layout.item_task, padre, false);
        return new TareaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int posicion) {
        Task tarea = listaTareas.get(posicion);
        holder.checkBox.setText(tarea.getTitulo());
        holder.checkBox.setChecked(tarea.estaCompletada());

        holder.checkBox.setOnCheckedChangeListener((boton, estaMarcado) -> {
            tarea.setCompletada(estaMarcado);
            alCambiarEstado.run();
        });
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }
}
