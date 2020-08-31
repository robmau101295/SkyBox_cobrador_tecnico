package skybox.com.scmtv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import skybox.com.scmtv.UI.MainActivity2_login;

import static skybox.com.scmtv.comun.Constantes.IP_DEL_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.PUERTO;
import static skybox.com.scmtv.comun.Constantes.numero_Cobrador;
import static skybox.com.scmtv.comun.Constantes.password_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.user_SERVIDOR;

public class MainActivity2_collector extends AppCompatActivity {

    @BindView(R.id.iB_cobrador)
    ImageButton iBCobrador;
    @BindView(R.id.iB_tenico)
    ImageButton iBTenico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_collector);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iB_cobrador, R.id.iB_tenico})
    public void onViewClicked(View view) {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        switch (view.getId()) {
            case R.id.iB_cobrador:

                Obj_editor.putString("codigo_cobtec", "3");
                Obj_editor.commit();
                numero_Cobrador = preferencias.getString("codigo_cobtec","");
                Toast.makeText(MainActivity2_collector.this,
                        "codigo: " + numero_Cobrador, Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity2_collector.this, MainActivity2_login.class);
                startActivity(i);
                break;
            case R.id.iB_tenico:
                Obj_editor.putString("codigo_cobtec", "1");
                Obj_editor.commit();
                numero_Cobrador = preferencias.getString("codigo_cobtec","");
                Toast.makeText(MainActivity2_collector.this,
                        "codigo: " + numero_Cobrador, Toast.LENGTH_LONG).show();
                Intent a = new Intent(MainActivity2_collector.this, MainActivity2_login.class);
                startActivity(a);
                break;
        }
    }
}