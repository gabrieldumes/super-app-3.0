package com.example.superapp30.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.superapp30.R;
import com.example.superapp30.model.Noticia;

public class VerNoticiaActivity extends AppCompatActivity {

    private ImageView image;
    private TextView textCreditoImagem, textTitulo, textData, textArtigo, textAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_noticia);

        image = findViewById(R.id.imageNoticia);
        textCreditoImagem = findViewById(R.id.textCreditoImagemNoticia);
        textTitulo = findViewById(R.id.textTituloNoticia);
        textData = findViewById(R.id.textDataNoticia);
        textArtigo = findViewById(R.id.textArtigoNoticia);
        textAutor = findViewById(R.id.textAutorNoticia);

        try {
            Bundle dados = getIntent().getExtras();
            Noticia noticia = (Noticia) dados.getSerializable("noticiaAtual");

            image.setImageResource(noticia.getImagem());
            textCreditoImagem.setText("Imagem: " + noticia.getCreditoFoto());
            textTitulo.setText(noticia.getTitulo());
            textData.setText(noticia.getData());
            textArtigo.setText(noticia.getArtigo());
            textAutor.setText("Autor: " + noticia.getAutor());
        } catch (Exception e) {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
            Log.i("INSETO ", e.getMessage());
        }
    }
}