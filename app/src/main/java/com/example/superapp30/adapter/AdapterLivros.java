package com.example.superapp30.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superapp30.R;
import com.example.superapp30.model.Livro;

import java.util.List;

public class AdapterLivros extends RecyclerView.Adapter<AdapterLivros.MyViewHolder> {

    private List<Livro> listaLivros;

    public AdapterLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_simples, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Livro livro = listaLivros.get(position);
        holder.textLivro.setText(livro.getLivro());
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textLivro;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textLivro = itemView.findViewById(R.id.textItemSimples);
        }
    }
}
