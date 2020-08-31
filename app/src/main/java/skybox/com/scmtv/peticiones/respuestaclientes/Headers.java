
package skybox.com.scmtv.peticiones.respuestaclientes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers {

    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("status")
    @Expose
    private Integer status;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Headers() {
    }

    /**
     * 
     * @param version
     * @param status
     */
    public Headers(Integer version, Integer status) {
        super();
        this.version = version;
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
