
package skybox.com.scmtv.peticiones.respuestadetalle;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetalleResponse {

    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DetalleResponse() {
    }

    /**
     * 
     * @param result
     */
    public DetalleResponse(List<Result> result) {
        super();
        this.result = result;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}
