package com.example.superapp30.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.superapp30.R;
import com.example.superapp30.helper.ArmazenamentoBancoDeDados;

public class NovoLivroActivity extends AppCompatActivity {

    private EditText editLivro;

    private ArmazenamentoBancoDeDados bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_livro);

        editLivro = findViewById(R.id.editLivro);

        bancoDeDados = new ArmazenamentoBancoDeDados(this, 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_salvar) {
            if (editLivro.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo livro VAZIO!", Toast.LENGTH_SHORT).show();
            } else {
                bancoDeDados.addLivro(editLivro.getText().toString());
                Toast.makeText(this, "Livro salvo com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}