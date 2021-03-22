package com.example.superapp30.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.superapp30.R;
import com.example.superapp30.helper.ArmazenamentoPreferencias;
import com.google.android.material.appbar.AppBarLayout;

public class InicioActivity extends AppCompatActivity {

    private EditText editNome;

    private ArmazenamentoPreferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        getSupportActionBar().hide();

        editNome = findViewById(R.id.editNome);

        preferencias = new ArmazenamentoPreferencias(this);

        editNome.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (editNome.getText().toString().isEmpty()) {
                        Toast.makeText(InicioActivity.this, "Nome INVÁLIDO!", Toast.LENGTH_SHORT).show();
                    } else {
                        preferencias.setNome(editNome.getText().toString());
                        Toast.makeText(InicioActivity.this, "Nome salvo com sucesso!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); //This line sets the default actions (finishing the current activity)
    }
}