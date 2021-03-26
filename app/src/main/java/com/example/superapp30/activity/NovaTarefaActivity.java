package com.example.superapp30.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.superapp30.R;
import com.example.superapp30.helper.ArmazenamentoBancoDeDados;
import com.example.superapp30.helper.Tarefa;

public class NovaTarefaActivity extends AppCompatActivity {

    private EditText editTarefa;
    private ArmazenamentoBancoDeDados bancoDeDados;

    private Tarefa tarefa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tarefa);

        editTarefa = findViewById(R.id.editTarefa);

        bancoDeDados = new ArmazenamentoBancoDeDados(this);

        try {
            Bundle dados = getIntent().getExtras();
            this.tarefa = bancoDeDados.getTarefaById(dados.getInt("idTarefa"));
            editTarefa.setText(tarefa.getTarefa());
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
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
                if (tarefa == null) {
                    bancoDeDados.addTarefa(editTarefa.getText().toString());
                    Toast.makeText(this, "Tarefa adicionada com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    bancoDeDados.updateTarefa(tarefa.getId(), editTarefa.getText().toString());
                    Toast.makeText(this, "Tarefa editada com sucesso!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}