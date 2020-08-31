package skybox.com.scmtv.peticiones.respuestas;

import com.google.gson.annotations.SerializedName;

public class Error{

	@SerializedName("msg")
	private String msg;

	@SerializedName("count")
	private int count;

	public String getMsg(){
		return msg;
	}

	public int getCount(){
		return count;
	}
}