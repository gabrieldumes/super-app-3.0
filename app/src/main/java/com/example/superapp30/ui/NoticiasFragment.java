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
        Noticia noticia = new Noticia(
                R.drawable.city_nout_gons,
                "City",
                "",
                "20/MAR/2021",
                "Seth Rims",
                "Nout Gons");
        noticia.setArtigo(getResources().getString(R.string.artigo_city));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.forest_pixabay,
                "Forest",
                "",
                "14/JUN/2020",
                "Carol Lee",
                "Pixabay");
        noticia.setArtigo(getResources().getString(R.string.artigo_forest));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.library_pixabay,
                "Library",
                "",
                "01/SET/2019",
                "Carol Lee",
                "Pixabay");
        noticia.setArtigo(getResources().getString(R.string.artigo_library));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.computers_pixabay,
                "Computers",
                "",
                "10/FEV/2021",
                "Seth Rims",
                "Pixabay");
        noticia.setArtigo(getResources().getString(R.string.artigo_computers));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.beach_alex,
                "Beach",
                "",
                "29/ABR/2020",
                "Matthew Olsen",
                "Alex");
        noticia.setArtigo(getResources().getString(R.string.artigo_beach));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.ads_negative_space,
                "Ads",
                "",
                "25/AGO/2020",
                "Carol Lee",
                "Matthew Olsen");
        noticia.setArtigo(getResources().getString(R.string.artigo_ads));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.hospital_oles_kanebckuu,
                "Hospital",
                "",
                "14/JAN/2021",
                "Mark Thompson",
                "Oles Kanebckuu");
        noticia.setArtigo(getResources().getString(R.string.artigo_hospital));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.grocery_store_pixabay,
                "Grocery Store",
                "",
                "08/MAR/2020",
                "Seth Rims",
                "Pixabay");
        noticia.setArtigo(getResources().getString(R.string.artigo_grocery_store));
        listaNoticias.add(noticia);

        noticia = new Noticia(
                R.drawable.garage_pixabay,
                "Garage",
                "",
                "01/SET/2019",
                "Mark Thompson",
                "Pixabay");
        noticia.setArtigo(getResources().getString(R.string.artigo_garage));
        listaNoticias.add(noticia);
    }
}