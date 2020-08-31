package skybox.com.scmtv.retrofit;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import skybox.com.scmtv.comun.Constantes;

public class SkyBoxCliente {

    private static SkyBoxCliente instance = null;
    private SkyBoxService skyboxService;
    private Retrofit retrofit;



    public SkyBoxCliente() {

        Constantes.BASE_URL = Constantes.HTTP_var + Constantes.IP_DEL_SERVIDOR + ":"
                + Constantes.PUERTO + Constantes.DataSnap_REST_TMethodsModule;

        String username = Constantes.user_SERVIDOR;
        String password = Constantes.password_SERVIDOR;

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic(username,password));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);


            }
        }).build();


        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        skyboxService = retrofit.create(SkyBoxService.class);
    }

    //Patrón Singleton
    public static SkyBoxCliente getInstance(){
        if(instance == null){
            instance = new SkyBoxCliente();
        }
        return instance;
    }

    public SkyBoxService getSkyboxService(){
        return skyboxService;
    }


}
