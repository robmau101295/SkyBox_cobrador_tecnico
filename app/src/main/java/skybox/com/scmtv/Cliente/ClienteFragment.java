package skybox.com.scmtv.Cliente;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skybox.com.scmtv.R;
import skybox.com.scmtv.comun.Constantes;
import skybox.com.scmtv.mostrardetalle;
import skybox.com.scmtv.peticiones.respuestaclientes.ClientResponse;
import skybox.com.scmtv.peticiones.respuestaclientes.Datum;
import skybox.com.scmtv.peticiones.respuestaclientes.Result;
import skybox.com.scmtv.retrofit.SkyBoxCliente;
import skybox.com.scmtv.retrofit.SkyBoxService;

/**
 * A fragment representing a list of Items.
 */
public class ClienteFragment extends Fragment {
    RecyclerView recyclerView;
    SkyBoxCliente skyBoxCliente;
    SkyBoxService skyBoxService;
    private MyClienteRecyclerViewAdapter adapterClientes;
    public List<Cliente> clientesList;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    public ClienteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ClienteFragment newInstance(int columnCount) {
        ClienteFragment fragment = new ClienteFragment();
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
        View view = inflater.inflate(R.layout.fragment_cliente_list, container, false);

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
            loadclientesdata();


        }


        return view;
    }

    private void retrofitInit() {
        skyBoxCliente = SkyBoxCliente.getInstance();
        skyBoxService = skyBoxCliente.getSkyboxService();
    }
    private void loadclientesdata(){
        clientesList = new ArrayList<>();

        if(!Constantes.URL_GLOBAL_BUSQUEDA_CLIENTES.isEmpty()){
            Call<ClientResponse> call = skyBoxService.buscarclientes(Constantes.URL_GLOBAL_BUSQUEDA_CLIENTES);
            call.enqueue(new Callback<ClientResponse>() {
                @Override
                public void onResponse(Call<ClientResponse> call, Response<ClientResponse> response) {
                    if(response.isSuccessful()){
                        //Toast.makeText(getContext(),"Respuesta exitosa",Toast.LENGTH_LONG).show();
                        ClientResponse respuesta = response.body();
                        List<Result> result = respuesta.getResult();
                        for(Result objetos : result){
                            List<Datum> datum = objetos.getData();
                            Constantes.ClientSeleccion = objetos.getData();
                            for(Datum valores : datum){
                                String contrato = valores.getContrato();
                                Integer codigo = valores.getId();
                                String codigo_text = codigo.toString().trim();
                                String nombreyapellido = valores.getNombre().trim() + " " + valores.getApellido().trim();
                                String telefono = valores.getTelefono1Contrato().trim();
                                String estado = valores.getEstatus().trim();
                                //Toast.makeText(getContext(), codigo_text+" "+nombreyapellido+" "+telefono+" "+estado, Toast.LENGTH_SHORT).show();
                                clientesList.add(new Cliente(codigo_text,codigo_text,nombreyapellido,telefono,estado));
                            }
                        }
                        adapterClientes = new MyClienteRecyclerViewAdapter(
                                getActivity(),
                                clientesList);
                        adapterClientes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "Selección: "+clientesList.get(recyclerView.getChildAdapterPosition(v)).getCodigo(),
                                        Toast.LENGTH_LONG).show();
                                String contrato = clientesList.get(recyclerView.getChildAdapterPosition(v)).getCodigo();
                                Intent i = new Intent(getContext(), mostrardetalle.class);
                                i.putExtra("contrato_cliente", contrato);
                                startActivity(i);
                            }
                        });
                        recyclerView.setAdapter(adapterClientes);

                    }else{
                        Toast.makeText(getContext(),"Algo ha ido mal", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ClientResponse> call, Throwable t) {
                    Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }


    }


}