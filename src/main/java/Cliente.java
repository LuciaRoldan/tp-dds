import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario{

	Documento documento; //les parece que el documento sea una clase??
	//porque tiene tipo y numero
	private String telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;
	
	Cliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena, Documento documento, String telefono, CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos){
		super(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
		this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
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