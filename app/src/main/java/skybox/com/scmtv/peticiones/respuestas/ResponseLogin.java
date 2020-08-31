package skybox.com.scmtv.peticiones.respuestas;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("result")
	private List<ResultItem> result;

	public List<ResultItem> getResult(){
		return result;
	}
}