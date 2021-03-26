package com.example.superapp30.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ArmazenamentoBancoDeDados {

    private Context context;
    private SQLiteDatabase database;

    public ArmazenamentoBancoDeDados(Context context) {
        this.context = context;
        try {
            database = context.openOrCreateDatabase("app_db", Context.MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "tarefa VARCHAR)");
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
    }

    public void addTarefa(String tarefa) {
        try {
            database.execSQL("INSERT INTO tarefas(tarefa) VALUES ('" + tarefa + "')");
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
    }

    public Tarefa getTarefa(int position) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM tarefas", null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");
            cursor.moveToPosition(position);
            return new Tarefa(cursor.getInt(indiceColunaId), cursor.getString(indiceColunaTarefa));
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return new Tarefa(-1, "Erro");
        }
    }

    public int getQtdTarefas() {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM tarefas", null);
            return cursor.getCount();
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return 0;
        }
    }

    public void deleteTarefa(int id) {
        try {
            database.execSQL("DELETE FROM tarefas WHERE id = " + id);
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
    }
}
