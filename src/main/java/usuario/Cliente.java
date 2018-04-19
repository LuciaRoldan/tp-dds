package usuario;

import categorias.CategoriaResidencial;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dispositivos.Dispositivo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;




public class Cliente extends Usuario {

	private Long numeroDocumento;
	private TipoDocumento tipoDocumento;
	private Long telefono;
	private long documento;
	private CategoriaResidencial categoriaResidencial;
	private String nombreYapellido;
	private ArrayList<Dispositivo> dispositivos;

	@JsonCreator
	public void inicializarCliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta,
			String nombreUsuario, String contrasena, TipoDocumento tipoDocumento,long numeroDocumento, 
			long telefono, CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos){
		
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.tipoDocumento = tipoDocumento;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.documento = numeroDocumento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
	}


	@JsonProperty("categoriaResidencial")
	public void setType(String type) throws IOException {
		this.categoriaResidencial = CategoriaResidencial.fromString(type);
	}



	//Getters and Setters

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

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public int cantidadDispositivos() {
		return dispositivos.size();
	}
	
	public boolean poseeDispositivosEncendidos() {
		return this.cantidadDispositivosEncendidos() > 0;
	}
	
	public int cantidadDispositivosEncendidos() {
		return dispositivos.stream().filter(dispositivo -> dispositivo.isEncendido()).collect(Collectors.toList()).size();
	}
	
	public int cantidadDispositivosApagados() {
		int cantidadApagados = this.cantidadDispositivos() - this.cantidadDispositivosEncendidos();
		return cantidadApagados;
	}
	
	
	
}