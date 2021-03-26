package com.example.superapp30.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.superapp30.R;
import com.example.superapp30.activity.NovaTarefaActivity;
import com.example.superapp30.adapter.AdapterTarefas;
import com.example.superapp30.helper.ArmazenamentoBancoDeDados;
import com.example.superapp30.helper.RecyclerItemClickListener;
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
                startActivity(new Intent(getActivity(), NovaTarefaActivity.class));
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTarefas.setLayoutManager(layoutManager);
        recyclerTarefas.setHasFixedSize(true);
        recyclerTarefas.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        recyclerTarefas.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        recyclerTarefas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Tarefa tarefa = listaTarefas.get(position);
                                Intent intent = new Intent(getActivity(), NovaTarefaActivity.class);
                                intent.putExtra("idTarefa", tarefa.getId());
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Tarefa tarefa = listaTarefas.get(position);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                                dialog.setTitle("Quer remover esta tarefa?");
                                dialog.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        bancoDeDados.deleteTarefa(tarefa.getId());
                                        Toast.makeText(getActivity(), "Tarefa excluída!", Toast.LENGTH_SHORT).show();
                                        onStart();
                                    }
                                });
                                dialog.setNegativeButton("Cancelar", null);
                                dialog.create().show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                ));

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