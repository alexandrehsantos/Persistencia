package br.com.fiap.persistencia.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import java.util.List;

import br.com.fiap.persistencia.dao.BaseDados;
import br.com.fiap.persistencia.model.Tarefa;

public class TarefaModel extends AndroidViewModel {
    private LiveData<List<Tarefa>> tarefas;
    private BaseDados bd;

    public TarefaModel(Application application) {
        super(application);
        bd = BaseDados.getDatabase(application.getApplicationContext());
        carregarDados();
    }

    public LiveData<List<Tarefa>> getTarefas() {
        return tarefas;
    }

    private void carregarDados() {
        tarefas = bd.tarefaDao().listarTodas();
    }
}
