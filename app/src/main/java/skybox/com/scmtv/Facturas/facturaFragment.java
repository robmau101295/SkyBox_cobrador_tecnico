package skybox.com.scmtv.Facturas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skybox.com.scmtv.R;
import skybox.com.scmtv.comun.Constantes;
import skybox.com.scmtv.peticiones.respuestadetalle.Datum;
import skybox.com.scmtv.peticiones.respuestadetalle.DetalleResponse;
import skybox.com.scmtv.peticiones.respuestadetalle.Result;
import skybox.com.scmtv.retrofit.SkyBoxCliente;
import skybox.com.scmtv.retrofit.SkyBoxService;

/**
 * A fragment representing a list of Items.
 */
public class facturaFragment extends Fragment {
    SkyBoxCliente skyBoxCliente;
    SkyBoxService skyBoxService;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private MyfacturaRecyclerViewAdapter AdapterFacturas;
    RecyclerView recyclerView;
    List<Factura> facturaList;


    public facturaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static facturaFragment newInstance(int columnCount) {
        facturaFragment fragment = new facturaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_factura_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            retrofitInit();
            LoadFacturas();
        }
        return view;
    }
    private void retrofitInit() {
        skyBoxCliente = SkyBoxCliente.getInstance();
        skyBoxService = skyBoxCliente.getSkyboxService();
    }

    private void LoadFacturas(){
        facturaList = new ArrayList<>();
        if(!Constantes.URL_GLOBAL_DETALLE_CLIENTES.isEmpty()){
            Call<DetalleResponse> call = skyBoxService.buscardetalle(Constantes.URL_GLOBAL_DETALLE_CLIENTES);
            call.enqueue(new Callback<DetalleResponse>() {
                @Override
                public void onResponse(Call<DetalleResponse> call, Response<DetalleResponse> response) {
                    if(response.isSuccessful()){
                        DetalleResponse respuesta = response.body();
                        List<Result> result = respuesta.getResult();
                        for(Result objetos : result){
                            List<Datum> datum = objetos.getData();
                            for(Datum valores : datum){
                                String numeroFactura = valores.getFactura();
                                Integer contratoFactura = valores.getContrato();
                                String descripcionFactura = valores.getDescripcion();
                                String vencimientoFactura = valores.getFechaVencimiento();
                                String importeFactura = valores.getImporte();
                                if(contratoFactura == Integer.parseInt(Constantes.contrato_recuperado)){
                                    facturaList.add(new Factura(numeroFactura,descripcionFactura,vencimientoFactura,importeFactura));
                                }

                            }
                        }
                        AdapterFacturas = new MyfacturaRecyclerViewAdapter(
                                getActivity(),
                                facturaList);
                        recyclerView.setAdapter(AdapterFacturas);
                    }
                }

                @Override
                public void onFailure(Call<DetalleResponse> call, Throwable t) {

                }
            });
        }
    }
}