package skybox.com.scmtv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static skybox.com.scmtv.comun.Constantes.IP_DEL_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.PUERTO;
import static skybox.com.scmtv.comun.Constantes.password_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.user_SERVIDOR;

public class config_servidor extends AppCompatActivity {
    SharedPreferences myPreferences;
    public static String IPServer;
    public static String UserServer;
    public static String PasswordServer;

    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.editTextServer)
    EditText editTextServer;
    @BindView(R.id.editTextUserServer)
    EditText editTextUserServer;
    @BindView(R.id.editTextPasswordServer)
    EditText editTextPasswordServer;
    @BindView(R.id.button_validar_servidor)
    Button buttonValidarServidor;
    @BindView(R.id.editTextPuerto)
    EditText editTextPuerto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_login_server);
        ButterKnife.bind(this);
        tvVersion.setText("V " + BuildConfig.VERSION_NAME);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

    }


    public void guardar() {
        IP_DEL_SERVIDOR = editTextServer.getText().toString();
        PUERTO = editTextPuerto.getText().toString();
        user_SERVIDOR = editTextUserServer.getText().toString();
        password_SERVIDOR = editTextPasswordServer.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        Obj_editor.putString("ip", IP_DEL_SERVIDOR);
        Obj_editor.putString("puerto", PUERTO);
        Obj_editor.putString("user", user_SERVIDOR);
        Obj_editor.putString("password", password_SERVIDOR);
        Obj_editor.commit();

        Toast.makeText(config_servidor.this, "Datos guardados correctamente", Toast.LENGTH_LONG).show();
        Toast.makeText(config_servidor.this,
                "IP SERVIDOR: " + IP_DEL_SERVIDOR + "PORT: " + PUERTO, Toast.LENGTH_LONG).show();
        finish();
        // Estado de conexion
        Intent i = new Intent(config_servidor.this, MainActivity2_collector.class);
        startActivity(i);
    }


    @OnClick(R.id.button_validar_servidor)
    public void onViewClicked() {
        guardar();
    }
}