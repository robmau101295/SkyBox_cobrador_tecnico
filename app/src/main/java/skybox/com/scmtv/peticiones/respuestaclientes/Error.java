
package skybox.com.scmtv.peticiones.respuestaclientes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Error() {
    }

    /**
     * 
     * @param msg
     * @param count
     */
    public Error(String msg, Integer count) {
        super();
        this.msg = msg;
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
