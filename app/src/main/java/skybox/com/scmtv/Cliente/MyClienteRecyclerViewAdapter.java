package skybox.com.scmtv.Cliente;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import skybox.com.scmtv.R;
import java.util.List;


public class MyClienteRecyclerViewAdapter extends RecyclerView.Adapter<MyClienteRecyclerViewAdapter.ViewHolder>
implements View.OnClickListener {
    private Context ctx;
    private final List<Cliente> mValues;
    private View.OnClickListener listener;

    public MyClienteRecyclerViewAdapter(Context context, List<Cliente> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cliente, parent, false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.codigo.setText(holder.mItem.getCodigo().trim());
        holder.nombreyapellido.setText(holder.mItem.getNombreyapellido());
        holder.telefono.setText(holder.mItem.getTelefono().trim());
        holder.estado.setText(holder.mItem.getEstado().trim());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    };

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView codigo;
        public final TextView nombreyapellido;
        public final TextView telefono;
        public final TextView estado;
        public Cliente mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            codigo = (TextView) view.findViewById(R.id.tvCodigo);
            nombreyapellido = (TextView) view.findViewById(R.id.tvNombreyApellidos);
            telefono = (TextView) view.findViewById(R.id.tvTelefono);
            estado = (TextView) view.findViewById(R.id.tvEstado);
        }

        @Override
        public String toString() {
            return super.toString() + codigo.getText();
        }
    }

}