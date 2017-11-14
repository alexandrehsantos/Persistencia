package br.com.fiap.persistencia.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.persistencia.model.Tarefa;

@Dao
public interface TarefaDAO {

    @Insert
    void criarTarefa(Tarefa tarefa);

    @Query("SELECT * FROM Tarefa")
    LiveData<List<Tarefa>> listarTodas();

    @Query("SELECT * FROM Tarefa WHERE id = :id")
    Tarefa listarPorId(int id);

    @Update
    void atualizar(Tarefa tarefa);

    @Delete
    void apagar(Tarefa tarefa);
}
