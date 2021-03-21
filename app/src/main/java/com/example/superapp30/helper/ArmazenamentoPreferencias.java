package com.example.superapp30.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class ArmazenamentoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String ARQUIVO_PREFERENCIAS = "arquivo.preferencias";

    private final String KEY_NOME = "nome";

    public ArmazenamentoPreferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setNome(String nome) {
        editor.putString(KEY_NOME, nome).commit();
    }

    public String getNome() {
        return preferences.getString(KEY_NOME, "Erro00x");
    }
}
