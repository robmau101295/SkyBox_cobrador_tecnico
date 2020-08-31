
package skybox.com.scmtv.peticiones.respuestaclientes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("headers")
    @Expose
    private Headers headers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param headers
     * @param data
     * @param error
     */
    public Result(List<Datum> data, Error error, Headers headers) {
        super();
        this.data = data;
        this.error = error;
        this.headers = headers;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

}
