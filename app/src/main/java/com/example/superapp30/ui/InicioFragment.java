package com.example.superapp30.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.superapp30.R;
import com.example.superapp30.helper.ArmazenamentoPreferencias;

public class InicioFragment extends Fragment {

    private TextView textNome;

    private ArmazenamentoPreferencias preferencias;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        textNome = view.findViewById(R.id.textNomeBemVindo);

        preferencias = new ArmazenamentoPreferencias(getActivity());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (preferencias.getNome().equals("Erro00x")) {
            textNome.setText("Olá");
        } else {
            textNome.setText("Olá, " + preferencias.getNome());
        }
    }
}