package skybox.com.scmtv.UI;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skybox.com.scmtv.BuildConfig;
import skybox.com.scmtv.Dialog.Alert;
import skybox.com.scmtv.R;
import skybox.com.scmtv.buscar_cliente;
import skybox.com.scmtv.comun.Constantes;
import skybox.com.scmtv.peticiones.respuestas.Error;
import skybox.com.scmtv.peticiones.respuestas.Headers;
import skybox.com.scmtv.peticiones.respuestas.ResponseLogin;
import skybox.com.scmtv.peticiones.respuestas.ResultItem;
import skybox.com.scmtv.peticiones.solicitudes.RequestLogin;
import skybox.com.scmtv.retrofit.SkyBoxCliente;
import skybox.com.scmtv.retrofit.SkyBoxService;

public class MainActivity2_login extends AppCompatActivity{
    //Constante asincrona RequestQueue - Metodo Volley
    private RequestQueue queue;
    @BindView(R.id.editTextUsuario)
    EditText editTextUsuario;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.button)
    Button button;

    SkyBoxCliente skyBoxCliente;
    SkyBoxService skyBoxService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_login);
        ButterKnife.bind(this);
        tvVersion.setText("V " + BuildConfig.VERSION_NAME);
        retrofitInit();

    }


    private void retrofitInit() {
        skyBoxCliente = SkyBoxCliente.getInstance();
        skyBoxService = skyBoxCliente.getSkyboxService();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
            iraLogin();
    }


    private void iraLogin(){

         String usuario = editTextUsuario.getText().toString().trim();
         String password = editTextPassword.getText().toString().trim();

        if(usuario.isEmpty()){
            editTextUsuario.setError("El usuario es requerido");
        }else if(password.isEmpty()){
            editTextPassword.setError("La contraseña es requerida");
        }else{
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferencias.edit();
            String codigo = preferencias.getString("codigo_cobtec","");
            String urlFinal = "Login/" + codigo +"/" + usuario + "/" + password;

            Call<ResponseLogin> call = skyBoxService.hacerLogin(urlFinal);

            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    int estado = 0;
                        String msg = null;
                        if(response.isSuccessful()){
                            ResponseLogin respuesta = response.body();
                            List<ResultItem> result = respuesta.getResult();
                            for(ResultItem objetos : result){
                                Headers header = objetos.getHeaders();
                                Error error = objetos.getError();
                                estado = header.getStatus();
                                msg = error.getMsg();
                            }
                        String status = Integer.toString(estado);
                    //    Toast.makeText(MainActivity2_login.this, status, Toast.LENGTH_LONG).show();

                       if(estado == 202){
                          iniciarActivity(msg,R.drawable.ic_iconfinder_success_1646004);
                       }else if(estado == 408){
                           Toast.makeText(MainActivity2_login.this, msg,Toast.LENGTH_LONG).show();
                       }else if(estado == 400){
                           Toast.makeText(MainActivity2_login.this, msg,Toast.LENGTH_LONG).show();
                       }else if(estado == 401){
                           msg = "El usuario o contraseña son inválidos o no existen.";
                           mostrarDialogo(msg,R.drawable.ic_datos_no_existen);
                       }else if(estado == 405){
                           Toast.makeText(MainActivity2_login.this, msg,Toast.LENGTH_LONG).show();
                       }
                    }
                }
                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    String msg_error = t.getMessage();
                    mostrarDialogo(msg_error,R.drawable.ic_icon_errordeconexion); }
            });
        }
    }

    //AlertDialog para LoginActivity
    public void iniciarActivity(String error, int img) {
        final Alert mAlert = new Alert(this);
        mAlert.setMessage(error);
        mAlert.setImagen(img);
        mAlert.setPositveButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2_login.this, buscar_cliente.class);
                startActivity(i);
                finish();
            }
        });
        mAlert.show();
    }
    public void mostrarDialogo(String error, int img) {
        final Alert mAlert = new Alert(this);
        mAlert.setMessage(error);
        mAlert.setImagen(img);
        mAlert.setPositveButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAlert.dismiss();
            }
        });
        mAlert.show();
    }
}