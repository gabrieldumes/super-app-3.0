package com.example.superapp30.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superapp30.R;
import com.example.superapp30.model.Noticia;

import java.util.List;

public class AdapterNoticias extends RecyclerView.Adapter<AdapterNoticias.MyViewHolder> {

    private List<Noticia> listaNoticias;

    public AdapterNoticias(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_noticias, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Noticia noticia = listaNoticias.get(position);
        holder.imagem.setImageResource(noticia.getImagem());
        holder.textTitulo.setText(noticia.getTitulo());
        holder.textArtigo.setText(noticia.getArtigo());
        holder.textData.setText(noticia.getData());
        holder.textAutor.setText(noticia.getAutor());
    }

    @Override
    public int getItemCount() {
        return listaNoticias.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagem;
        private TextView textTitulo, textArtigo, textData, textAutor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagem = itemView.findViewById(R.id.imageItemNoticias);
            textTitulo = itemView.findViewById(R.id.textItemTituloNoticias);
            textArtigo = itemView.findViewById(R.id.textArtigoItemNoticias);
            textData = itemView.findViewById(R.id.textItemData);
            textAutor = itemView.findViewById(R.id.textItemAutor);
        }
    }
}
