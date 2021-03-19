package com.example.superapp30.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.superapp30.R;
import com.example.superapp30.adapter.AdapterNoticias;
import com.example.superapp30.model.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiasFragment extends Fragment {

    private RecyclerView recyclerViewNoticias;

    private List<Noticia> listaNoticias = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        recyclerViewNoticias = view.findViewById(R.id.recyclerViewNoticias);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewNoticias.setLayoutManager(layoutManager);
        recyclerViewNoticias.setHasFixedSize(true);

        criarNoticas();

        AdapterNoticias adapter = new AdapterNoticias(listaNoticias);
        recyclerViewNoticias.setAdapter(adapter);

        return view;
    }

    public void criarNoticas() {
        Noticia noticia = new Noticia(R.drawable.countryside, "Artigo 1: Countryside", "");
        noticia.setArtigo(getResources().getString(R.string.noticia_countryside));
        listaNoticias.add(noticia);

        noticia = new Noticia(R.drawable.stars, "Artigo 2: Stars", "");
        noticia.setArtigo(getResources().getString(R.string.noticia_stars));
        listaNoticias.add(noticia);

        noticia = new Noticia(R.drawable.arch, "Artigo 3: Arquitetura", "");
        noticia.setArtigo(getResources().getString(R.string.noticia_arch));
        listaNoticias.add(noticia);

        noticia = new Noticia(R.drawable.car, "Artigo 4: Carro", "");
        noticia.setArtigo(getResources().getString(R.string.noticia_car));
        listaNoticias.add(noticia);

        noticia = new Noticia(R.drawable.boson, "Artigo 5: Bóson", "");
        noticia.setArtigo(getResources().getString(R.string.noticia_boson));
        listaNoticias.add(noticia);
    }
}