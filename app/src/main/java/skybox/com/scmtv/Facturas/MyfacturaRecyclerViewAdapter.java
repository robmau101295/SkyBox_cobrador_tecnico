package skybox.com.scmtv.Facturas;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import skybox.com.scmtv.R;
import skybox.com.scmtv.comun.Constantes;


public class MyfacturaRecyclerViewAdapter extends RecyclerView.Adapter<MyfacturaRecyclerViewAdapter.ViewHolder>
implements View.OnClickListener{

    private final List<Factura> mValues;
    View view;
    private Context ctx;
    private View.OnClickListener listener;
    int posiciomarcada = 0;
    private int lastSelectedPosition = -1;

    public MyfacturaRecyclerViewAdapter(Context context, List<Factura> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_factura, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Constantes.ArrayFacturas = new ArrayList<>();
        holder.mItem = mValues.get(position);
        holder.tv_numerofactura.setText(holder.mItem.getNumerofactura());
        holder.tv_descripcion.setText(holder.mItem.getDescripcion());
        holder.tv_vencimiento.setText(holder.mItem.getVencimiento());
        holder.tv_importe.setText(holder.mItem.getImporte());
        CheckBox checkBox = holder.cb_Factura;

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    Toast.makeText(MyfacturaRecyclerViewAdapter.this.ctx,
                        "Activado",
                        Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MyfacturaRecyclerViewAdapter.this.ctx,
                            "No Activado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


//                lastSelectedPosition = position;
//                holder.rb_radioButton.setChecked(true);
//                String nfactura = holder.mItem.getNumerofactura();
//                String descripcion = holder.mItem.getDescripcion();
//                String vencimiento = holder.mItem.getVencimiento();
//                String importe = holder.mItem.getImporte();
//                Constantes.ArrayFacturas.add(new Factura(nfactura, descripcion, vencimiento, importe));
//                Toast.makeText(MyfacturaRecyclerViewAdapter.this.ctx,
//                        "Factura: " + holder.mItem.getNumerofactura() + " agregada.",
//                        Toast.LENGTH_SHORT).show();
//                notifyDataSetChanged();


//                if(!Constantes.ArrayFacturas.isEmpty()){
//                    for (Factura valor : Constantes.ArrayFacturas) {
//                        if (valor.getNumerofactura() == holder.mItem.getNumerofactura()) {
//                            holder.rb_radioButton.setChecked(false);
//                            Toast.makeText(MyfacturaRecyclerViewAdapter.this.ctx,
//                                    "Se retiro: " + holder.mItem.getNumerofactura(),
//                                    Toast.LENGTH_SHORT).show();
//                            notifyDataSetChanged();
//                        }
//                    }
//                }


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
        public final LinearLayout linearlayout;
        public final TextView tv_numerofactura;
        public final TextView tv_descripcion;
        public final TextView tv_vencimiento;
        public final TextView tv_importe;
        public final CheckBox cb_Factura;
        public Factura mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            linearlayout = view.findViewById(R.id.linearLayoutSeleccionable);
            tv_numerofactura = view.findViewById(R.id.tvNFactura);
            tv_descripcion = view.findViewById(R.id.tvVencimientoFactura);
            tv_vencimiento = view.findViewById(R.id.tvVencimientoFactura);
            tv_importe = view.findViewById(R.id.tvImporteFactura);
            cb_Factura = view.findViewById(R.id.checkboxPrincipal);






        }

        @Override
        public String toString() {
            return super.toString() + tv_numerofactura.getText();
        }
    }
}