package br.com.fiap.persistencia.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fiap.persistencia.R;
import br.com.fiap.persistencia.model.Tarefa;
import br.com.fiap.persistencia.view.listener.OnItemClickListener;



public class TarefaAdapter extends
        RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {
    private List<Tarefa> tarefas;

    private final OnItemClickListener listener;

    public TarefaAdapter(List<Tarefa> tarefas, OnItemClickListener deleteClick) {
        this.tarefas = tarefas;
        this.listener = deleteClick;
    }

    public void setList(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public TarefaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_tarefa, parent, false);
        return new TarefaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TarefaViewHolder holder, final int i) {
        Tarefa tarefa = tarefas.get(i);
        holder.txtTitulo.setText(tarefa.getTitulo());
        holder.txtTarefa.setText(tarefa.getDescricao());

        holder.btApagar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public static class TarefaViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtTarefa;
        ImageView btApagar;

        public TarefaViewHolder(View v) {
            super(v);
            txtTitulo = (TextView) v.findViewById(R.id.txtTitulo);
            txtTarefa = (TextView) v.findViewById(R.id.txtTarefa);
            btApagar = (ImageView) v.findViewById(R.id.btApagar);
        }
    }

    public Tarefa getTarefa(int position) {
        return tarefas.get(position);
    }
}

