package skybox.com.scmtv;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import skybox.com.scmtv.Facturas.facturaFragment;
import skybox.com.scmtv.comun.Constantes;
import skybox.com.scmtv.peticiones.respuestaclientes.Datum;
import skybox.com.scmtv.retrofit.SkyBoxCliente;
import skybox.com.scmtv.retrofit.SkyBoxService;

public class mostrardetalle extends AppCompatActivity {
    SkyBoxCliente skyBoxCliente;
    SkyBoxService skyBoxService;

    @BindView(R.id.tvNombreUsuario)
    TextView tvNombreUsuario;
    @BindView(R.id.tvCodigoCliente)
    TextView tvCodigoCliente;
    @BindView(R.id.tvEstadoCliente)
    TextView tvEstadoCliente;
    @BindView(R.id.tvCorreoElectronico)
    TextView tvCorreoElectronico;
    @BindView(R.id.tvTelefono)
    TextView tvTelefono;
    @BindView(R.id.tvLocalidad)
    TextView tvLocalidad;
    @BindView(R.id.tvSector)
    TextView tvSector;
    @BindView(R.id.tvCalle)
    TextView tvCalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrardetalle);
        ButterKnife.bind(this);

        retrofitInit();

        Bundle datos = this.getIntent().getExtras();
        Constantes.contrato_recuperado = datos.getString("contrato_cliente");

        Constantes.URL_PARCIAL_DETALLE_CLIENTES = "GetInvoices/" + Constantes.contrato_recuperado;
        Constantes.URL_GLOBAL_DETALLE_CLIENTES = Constantes.BASE_URL +
                Constantes.URL_PARCIAL_DETALLE_CLIENTES;

        mostrardatosClientes();

        Toast.makeText(this, Constantes.URL_GLOBAL_DETALLE_CLIENTES, Toast.LENGTH_SHORT).show();

      /*  getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_factura, new facturaFragment())
                .commit();*/

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_factura, new facturaFragment())
                .commit();

    }

    private void mostrardatosClientes(){
        String nombreCliente = null;
        int idClienteInt = 0;
        int estadoCliente = 0;
        String localidadCliente = null, sectorCliente = null, calleCliente = null;
        String telefono1 = null, telefono2 = null;

        for (Datum valores : Constantes.ClientSeleccion) {
                nombreCliente = valores.getNombre();
                idClienteInt = valores.getId();
                estadoCliente = valores.getEstatusContrato();
                localidadCliente = valores.getLocalidad();
                sectorCliente = valores.getSector();
                calleCliente = valores.getCalle();
                telefono1 = valores.getTelefono1Contrato();
                telefono2 = valores.getTelefono2Contrato();
        }
            tvNombreUsuario.setText(nombreCliente);
            tvCodigoCliente.setText(Integer.toString(idClienteInt));
            tvEstadoCliente.setText(Integer.toString(estadoCliente));
            tvLocalidad.setText(localidadCliente);
            tvSector.setText(sectorCliente);
            tvCalle.setText(calleCliente);
            tvTelefono.setText(telefono1 +" / "+ telefono2);
    }

    private void retrofitInit() {
        skyBoxCliente = SkyBoxCliente.getInstance();
        skyBoxService = skyBoxCliente.getSkyboxService();
    }

}