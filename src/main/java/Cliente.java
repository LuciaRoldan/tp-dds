import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario{
	Documento documento; //les parece que el documento sea una clase??
	//porque tiene tipo y numero
	String telefono;
	Categoria categoria;
	ArrayList<Dispositivo> dispositivos;
	
	Cliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena, Documento documento, String telefono, Categoria categoria, ArrayList<Dispositivo> dispositivos){
		super(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
		this.documento = documento;
		this.telefono = telefono;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
	}
	
	
	
	
	
	
	
	//Getters and Setters
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Dispositivo> getDispotivos() {
		return dispotivos;
	}
	public void setDispotivos(ArrayList<Dispositivo> dispotivos) {
		this.dispotivos = dispotivos;
	}
	
	
}