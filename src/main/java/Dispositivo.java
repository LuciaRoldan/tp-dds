import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dispositivo {
	String nombre;
	int kWh;
	boolean encendido;
    TipoDeDispositivo tipoDeDispositivo;

	Dispositivo(String nombre, int kWh, boolean encendido,TipoDeDispositivo tipoDeDispositivo) throws IOException {
		this.nombre = nombre;
		this.kWh = kWh;
		this.encendido = encendido;
		this.tipoDeDispositivo = tipoDeDispositivo;
	}




	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getkWh() {
		return kWh;
	}
	public void setkWh(int kWh) {
		this.kWh = kWh;
	}
	public boolean isEncendido() {
		return encendido;
	}
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}


	///////////////////// PARSEAR OBJETO ///////////////////////////

    /*
    Gson gson = new Gson();
    // 1. JSON to Java object, read it from a file.
    Dispositivo disp = gson.fromJson(new FileReader("/home/matias/2018-vn-group-19/src/main/Resources/file.json"), Dispositivo.class);
    */

    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "{'name' : 'mkyong'}";

    //JSON from file to Object
    Dispositivo prueba = mapper.readValue(new File("src/main/Resources/file.json"), Dispositivo.class);

    //JSON from String to Object
    //Dispositivo user = mapper.readValue(jsonInString, User.class);

}


