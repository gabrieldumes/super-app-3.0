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
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.superapp30.R;
import com.example.superapp30.activity.NovoLivroActivity;
import com.example.superapp30.adapter.AdapterLivros;
import com.example.superapp30.helper.ArmazenamentoBancoDeDados;
import com.example.superapp30.helper.RecyclerItemClickListener;
import com.example.superapp30.model.Livro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaLivrosFragment extends Fragment {

    private RecyclerView recyclerLivros;
    private FloatingActionButton fabAdicionarLivro;

    private ArmazenamentoBancoDeDados bancoDeDados;

    private List<Livro> listaLivros = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_livros, container, false);

        recyclerLivros = view.findViewById(R.id.recyclerLivros);
        fabAdicionarLivro = view.findViewById(R.id.fabAdicionarLivro);

        bancoDeDados = new ArmazenamentoBancoDeDados(getActivity(), 1);

        fabAdicionarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NovoLivroActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerLivros.setLayoutManager(layoutManager);

        recyclerLivros.setHasFixedSize(true);
        recyclerLivros.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        recyclerLivros.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        recyclerLivros,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Livro livro = listaLivros.get(position);
                                Intent intent = new Intent(getActivity(), NovoLivroActivity.class);
                                intent.putExtra("idLivro", livro.getId());
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //
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
        listaLivros.clear();
        popularListaLivros();
        AdapterLivros adapterLivros = new AdapterLivros(listaLivros);
        recyclerLivros.setAdapter(adapterLivros);
    }

    public void popularListaLivros() {
        for (int i = 0; i < bancoDeDados.getQtdLivros(); i ++) {
            Livro livro = bancoDeDados.getLivro(i);
            listaLivros.add(livro);
        }
    }
}