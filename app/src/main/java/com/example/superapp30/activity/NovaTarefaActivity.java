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

public class NovaTarefaActivity extends AppCompatActivity {

    private EditText editTarefa;
    private ArmazenamentoBancoDeDados bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tarefa);

        editTarefa = findViewById(R.id.editTarefa);

        bancoDeDados = new ArmazenamentoBancoDeDados(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_salvar) {
            if (editTarefa.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Campo tarefa vazio!", Toast.LENGTH_SHORT).show();
            } else {
                bancoDeDados.addTarefa(editTarefa.getText().toString());
                Toast.makeText(this, "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}