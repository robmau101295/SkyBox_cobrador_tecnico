package skybox.com.scmtv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static skybox.com.scmtv.comun.Constantes.IP_DEL_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.IP_DEL_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.PUERTO;
import static skybox.com.scmtv.comun.Constantes.password_SERVIDOR;
import static skybox.com.scmtv.comun.Constantes.user_SERVIDOR;


public class MainActivity extends AppCompatActivity {
    private ObjectAnimator progressAnimator;



    @BindView(R.id.progressBar)
    ProgressBar progressBarAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        Init();
        progressAnimator.start();
        progressAnimator.setDuration(2000);
        progressAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);



                SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
                //Guardo la IP en una variable global
                IP_DEL_SERVIDOR = preferences.getString("ip", "");
                PUERTO = preferences.getString("puerto", "");
                user_SERVIDOR = preferences.getString("user", "");
                password_SERVIDOR = preferences.getString("password", "");

                if(IP_DEL_SERVIDOR.isEmpty()){
                    Intent i = new Intent(MainActivity.this, config_servidor.class);
                    startActivity(i);
                    progressBarAnimation.setVisibility(View.GONE);
                }else{
                    //Estado conexion
                    Toast.makeText(MainActivity.this,
                            "IP SERVIDOR: " + IP_DEL_SERVIDOR + "PORT: " + PUERTO, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, MainActivity2_collector.class);
                    startActivity(i);
                    progressBarAnimation.setVisibility(View.GONE);
                }





            }
        });



    }

    private void Init() {
        progressAnimator = ObjectAnimator.ofInt(progressBarAnimation, "progress",0,100);
    }
}