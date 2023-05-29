package brandao.android.supertrunfodino.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import brandao.android.supertrunfodino.Model.Carta;
import brandao.android.supertrunfodino.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Carta> listaCartas;

    public Adapter(List<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Carta carta = listaCartas.get(position);
        holder.nome.setText(carta.nome);
    }


    @Override
    public int getItemCount() {
        return listaCartas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeAdapter);
        }
    }

}

