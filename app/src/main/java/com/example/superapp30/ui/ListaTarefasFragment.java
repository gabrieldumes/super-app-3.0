package com.example.superapp30.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.superapp30.R;
import com.example.superapp30.activity.NovaNotaActivity;
import com.example.superapp30.adapter.AdapterTarefas;
import com.example.superapp30.helper.ArmazenamentoBancoDeDados;
import com.example.superapp30.helper.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefasFragment extends Fragment {

    private FloatingActionButton fabAdicionarTarefa;
    private RecyclerView recyclerTarefas;
    private ArmazenamentoBancoDeDados bancoDeDados;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_tarefas, container, false);

        fabAdicionarTarefa = view.findViewById(R.id.fabAdicionarTarefa);
        recyclerTarefas = view.findViewById(R.id.recyclerTarefas);

        bancoDeDados = new ArmazenamentoBancoDeDados(getActivity());

        fabAdicionarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NovaNotaActivity.class));
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTarefas.setLayoutManager(layoutManager);
        recyclerTarefas.setHasFixedSize(true);
        recyclerTarefas.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listaTarefas.clear();
        popularListaTarefas();
        AdapterTarefas adapterTarefas = new AdapterTarefas(listaTarefas);
        recyclerTarefas.setAdapter(adapterTarefas);
    }

    public void popularListaTarefas() {
        for (int i = 0; i < bancoDeDados.getQtdTarefas(); i++) {
            Tarefa tarefa = bancoDeDados.getTarefa(i);
            listaTarefas.add(tarefa);
        }
    }
}