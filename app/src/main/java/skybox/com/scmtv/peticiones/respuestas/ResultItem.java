package skybox.com.scmtv.peticiones.respuestas;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("headers")
	private Headers headers;

	@SerializedName("data")
	private List<Object> data;

	@SerializedName("error")
	private Error error;

	public Headers getHeaders(){
		return headers;
	}

	public List<Object> getData(){
		return data;
	}

	public Error getError(){
		return error;
	}
}