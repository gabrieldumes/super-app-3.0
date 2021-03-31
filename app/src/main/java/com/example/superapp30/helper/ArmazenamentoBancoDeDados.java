package com.example.superapp30.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.superapp30.model.Livro;
import com.example.superapp30.model.Tarefa;

public class ArmazenamentoBancoDeDados {

    private Context context;
    private SQLiteDatabase database;

    public ArmazenamentoBancoDeDados(Context context, int app) {
        //app=0 --> Lista de Tarefas
        //app=1 --> Lista de Livros
        this.context = context;
        try {
            database = context.openOrCreateDatabase("app_db", Context.MODE_PRIVATE, null);
            if (app == 0) {
                database.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "tarefa VARCHAR)");
            } else if (app == 1) {
                database.execSQL("CREATE TABLE IF NOT EXISTS livros(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "livro VARCHAR)");
            }
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

    public Tarefa getTarefaById(int id) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM tarefas WHERE id = " + id, null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");
            cursor.moveToFirst();
            return new Tarefa(cursor.getInt(indiceColunaId), cursor.getString(indiceColunaTarefa));
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return new Tarefa(-1, "Erro");
        }
    }

    public void updateTarefa(int id, String tarefa) {
        try {
            database.execSQL("UPDATE tarefas SET tarefa = '" + tarefa + "' WHERE id = " + id);
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
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

    public void addLivro(String livro) {
        try {
            database.execSQL("INSERT INTO livros(livro) VALUES ('" + livro + "')");
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
    }

    public Livro getLivro(int position) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM livros", null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaLivro = cursor.getColumnIndex("livro");
            cursor.moveToPosition(position);
            return new Livro(cursor.getInt(indiceColunaId), cursor.getString(indiceColunaLivro));
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return new Livro(-1, "Erro");
        }
    }

    public Livro getLivroById(int id) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM livros WHERE id = " + id, null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaLivro = cursor.getColumnIndex("livro");
            cursor.moveToFirst();
            return new Livro(cursor.getInt(indiceColunaId), cursor.getString(indiceColunaLivro));
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return new Livro(-1, "Erro");
        }
    }

    public int getQtdLivros() {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM livros", null);
            return cursor.getCount();
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
            return 0;
        }
    }

    public void updateLivro(int id, String livro) {
        try {
            database.execSQL("UPDATE livros SET livro = '" + livro + "' WHERE id = " + id);
        } catch (Exception e) {
            Log.i("INSETO", e.getMessage());
        }
    }
}
