
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




}


