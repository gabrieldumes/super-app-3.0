package com.example.superapp30.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.superapp30.R;
import com.example.superapp30.activity.NovaNotaActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaTarefasFragment extends Fragment {

    private FloatingActionButton fabAdicionarTarefa;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_tarefas, container, false);

        fabAdicionarTarefa = view.findViewById(R.id.fabAdicionarTarefa);

        fabAdicionarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NovaNotaActivity.class));
            }
        });

        return view;
    }
}