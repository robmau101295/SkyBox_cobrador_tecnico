package skybox.com.scmtv.peticiones.respuestas;

import com.google.gson.annotations.SerializedName;

public class Headers{

	@SerializedName("version")
	private int version;

	@SerializedName("status")
	private int status;

	public int getVersion(){
		return version;
	}

	public int getStatus(){
		return status;
	}
}