package ao.co.isptec.aplm.laboratorio4.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ao.co.isptec.aplm.laboratorio4.R;
import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;
import java.util.ArrayList;
import java.util.List;

public class TrajetoriaAdapter extends RecyclerView.Adapter<TrajetoriaAdapter.TrajetoriaViewHolder> {
    private List<Trajetoria> trajetorias = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Trajetoria trajetoria);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setTrajetorias(List<Trajetoria> trajetorias) {
        this.trajetorias = trajetorias;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrajetoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trajetoria, parent, false);
        return new TrajetoriaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrajetoriaViewHolder holder, int position) {
        Trajetoria trajetoria = trajetorias.get(position);
        holder.textName.setText(trajetoria.getName());
        holder.textDetails.setText(trajetoria.getDetails());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(trajetoria);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trajetorias.size();
    }

    static class TrajetoriaViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textDetails;

        TrajetoriaViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textDetails = itemView.findViewById(R.id.textDetails);
        }
    }
}