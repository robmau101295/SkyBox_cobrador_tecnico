
package skybox.com.scmtv.peticiones.solicitudes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestLogin {

    @SerializedName("tipo_entrada")
    @Expose
    private String tipoEntrada;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestLogin() {
    }

    /**
     * 
     * @param password
     * @param usuario
     * @param tipoEntrada
     */
    public RequestLogin(String tipoEntrada, String usuario, String password) {
        super();
        this.tipoEntrada = tipoEntrada;
        this.usuario = usuario;
        this.password = password;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
