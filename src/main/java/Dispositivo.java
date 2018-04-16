import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.FileReader;

public class Dispositivo {
	String nombre;
	int kWh;
	boolean encendido;
    TipoDeDispositivo tipoDeDispositivo;

	Dispositivo(String nombre, int kWh, boolean encendido,TipoDeDispositivo tipoDeDispositivo){
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

    File f = new File("NewFile.txt");

    // 1. JSON to Java object, read it from a file.
    Dispositivo disp = gson.fromJson(new FileReader(f), Dispositivo.class);

    */


}


