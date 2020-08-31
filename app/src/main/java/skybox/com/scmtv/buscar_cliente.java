package skybox.com.scmtv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skybox.com.scmtv.Cliente.Cliente;
import skybox.com.scmtv.Cliente.ClienteFragment;
import skybox.com.scmtv.Cliente.MyClienteRecyclerViewAdapter;
import skybox.com.scmtv.comun.Constantes;
import skybox.com.scmtv.peticiones.respuestaclientes.ClientResponse;
import skybox.com.scmtv.peticiones.respuestaclientes.Datum;
import skybox.com.scmtv.peticiones.respuestaclientes.Result;
import skybox.com.scmtv.peticiones.respuestas.Error;
import skybox.com.scmtv.peticiones.respuestas.Headers;
import skybox.com.scmtv.peticiones.respuestas.ResponseLogin;
import skybox.com.scmtv.peticiones.respuestas.ResultItem;
import skybox.com.scmtv.retrofit.SkyBoxCliente;
import skybox.com.scmtv.retrofit.SkyBoxService;
import skybox.com.scmtv.Cliente.Cliente;

public class buscar_cliente extends AppCompatActivity {

    @BindView(R.id.radiobuttonCodigo)
    RadioButton radiobuttonCodigo;
    @BindView(R.id.radiobuttonCedula)
    RadioButton radiobuttonCedula;
    @BindView(R.id.radiobuttonNombre)
    RadioButton radiobuttonNombre;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.editText_buscar)
    EditText editTextBuscar;

    SkyBoxCliente skyBoxCliente;
    SkyBoxService skyBoxService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);
        ButterKnife.bind(this);
        skyBoxCliente = SkyBoxCliente.getInstance();
        skyBoxService = skyBoxCliente.getSkyboxService();
        retrofitInit();
        //Bienvenidos a la patar de buscar cliente
    }

    private void retrofitInit() {

    }


    @OnClick({R.id.radiobuttonCodigo, R.id.radiobuttonCedula, R.id.radiobuttonNombre})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radiobuttonCodigo:
                editTextBuscar.setHint("Ingrese el código del cliente");
                Constantes.codigo_global_busqueda_clientes = "0";
                break;
            case R.id.radiobuttonCedula:
                editTextBuscar.setHint("Ingrese la cédula del cliente");
                Constantes.codigo_global_busqueda_clientes = "3";
                break;
            case R.id.radiobuttonNombre:
                editTextBuscar.setHint("Ingrese el nombre del cliente");
                Constantes.codigo_global_busqueda_clientes = "1";
                break;
        }
    }


    private void irabusqueda() {
        String parametro = editTextBuscar.getText().toString().trim();
        if (parametro.isEmpty()) {
            editTextBuscar.setError("El parametro es requerido");
        } else {
            Constantes.URL_PARCIAL_BUSQUEDA_CLIENTES = "GetRecords/" + Constantes.codigo_global_busqueda_clientes + "/" + parametro;
            Constantes.URL_GLOBAL_BUSQUEDA_CLIENTES = Constantes.BASE_URL +
                    Constantes.URL_PARCIAL_BUSQUEDA_CLIENTES;
        }
    }

    @OnClick(R.id.button_buscar)
    public void onViewClicked() {
        irabusqueda();
       // Toast.makeText(buscar_cliente.this,Constantes.URL_GLOBAL_BUSQUEDA_CLIENTES, Toast.LENGTH_LONG).show();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ClienteFragment())
                .commit();

    }


}