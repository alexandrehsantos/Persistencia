package br.com.fiap.persistencia.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.fiap.persistencia.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class BaseDados extends RoomDatabase {

    private static BaseDados INSTANCE;

    public static BaseDados getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            BaseDados.class,
                            "tasks")
                            .build();
        }
        return INSTANCE;
    }

    public abstract TarefaDAO tarefaDao();

}