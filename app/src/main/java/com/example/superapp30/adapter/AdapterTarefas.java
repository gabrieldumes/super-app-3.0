package com.example.superapp30.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superapp30.R;
import com.example.superapp30.helper.Tarefa;

import java.util.List;

public class AdapterTarefas extends RecyclerView.Adapter<AdapterTarefas.MyViewHolder> {

    private List<Tarefa> listaTarefas;

    public AdapterTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_tarefas, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);
        holder.textTarefa.setText(tarefa.getTarefa());
    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textTarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTarefa = itemView.findViewById(R.id.textItemTarefa);
        }
    }
}
