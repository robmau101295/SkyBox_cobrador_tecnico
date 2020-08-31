package skybox.com.scmtv.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import skybox.com.scmtv.peticiones.respuestaclientes.ClientResponse;
import skybox.com.scmtv.peticiones.respuestadetalle.DetalleResponse;
import skybox.com.scmtv.peticiones.respuestas.ResponseLogin;

public interface SkyBoxService {

    @GET
    Call<ResponseLogin> hacerLogin(@Url String url);

    @GET
    Call<ClientResponse> buscarclientes(@Url String url);

    @GET
    Call<DetalleResponse> buscardetalle(@Url String url);
}
