package skybox.com.scmtv.comun;

import android.app.Dialog;

import java.util.List;

import skybox.com.scmtv.Cliente.Cliente;
import skybox.com.scmtv.Facturas.Factura;
import skybox.com.scmtv.peticiones.respuestaclientes.ClientResponse;
import skybox.com.scmtv.peticiones.respuestaclientes.Datum;

public class Constantes {
    public static String HTTP_var = "http://";
    public static String IP_DEL_SERVIDOR = "";
    public static String PUERTO = "";
    public static String DataSnap_REST_TMethodsModule = "/DataSnap/REST/TMethodsModule/";
    public static String BASE_URL;
    public static String user_SERVIDOR;
    public static String password_SERVIDOR;
    public static String numero_Cobrador = "";
    public static String numero_Tecnico = "";
    public static String API_SKYBOX_URL_SERVER1 = "http://74.208.73.121:60090/DataSnap/REST/TMethodsModule/";
    public static Dialog mdialog;
    public static String URL_GLOBAL_BUSQUEDA_CLIENTES = "";
    public static String URL_PARCIAL_BUSQUEDA_CLIENTES = "";
    public static String URL_GLOBAL_DETALLE_CLIENTES = "";
    public static String URL_PARCIAL_DETALLE_CLIENTES = "";
    public static String codigo_global_busqueda_clientes = "0";
    //MostrarDetalle
    public static List<Datum> ClientSeleccion;
    public static String contrato_recuperado = "";
    public static List<Factura> ArrayFacturas;
}

