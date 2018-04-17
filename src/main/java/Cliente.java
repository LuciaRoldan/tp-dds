import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario{

	long numeroDocumento;
	String tipoDocumento; //les parece que el documento sea una clase??
	//porque tiene tipo y numero
	private long telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;
	
	public void inicilalizarCliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena, String tipoDocumento,long numeroDocumento, long telefono, CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos){
		this.tipoDocumento = tipoDocumento;
		this.domicilio = domicilio;
		this.nombreYApellido = nombreYApellido;
		this.fechaDeAlta = fechaDeAlta;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		//this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
	}

	//Getters and Setters

	//public Documento getDocumento() {return documento;}
	//public void setDocumento(Documento documento) {this.documento = documento;}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public CategoriaResidencial getCategoriaResidencial() {
		return categoriaResidencial;
	}
	public void setCategoriaResidencial(CategoriaResidencial categoriaResidencial) {
		this.categoriaResidencial = categoriaResidencial;
	}

	public ArrayList<Dispositivo> getDispotivos() {
		return this.dispositivos;
	}
	public void setDispotivos(ArrayList<Dispositivo> listaDispositivos) {
		this.dispositivos = listaDispositivos;
	}
	
	
}