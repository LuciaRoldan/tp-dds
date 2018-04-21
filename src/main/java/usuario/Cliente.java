package usuario;

import categorias.CategoriaResidencial;
import com.fasterxml.jackson.annotation.JsonProperty;
import dispositivos.Dispositivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static usuario.TipoDeUsuario.CLIENTE;

public class Cliente extends Usuario {

	private TipoDocumento tipoDocumento;
	private int documento;
	private int telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;

	public Cliente(){

	}


	public Cliente(String nombreYapellido, String domicilio, String fechaDeAlta, String nombreDeUsuario,
				   String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
				   CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos) {

		super.inicializar(nombreYApellido, fechaDeAlta, nombreDeUsuario, nombreDeUsuario, contrasena ,CLIENTE);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
	}

	@JsonProperty("categoriaResidencial")
	public void setType(String type) throws IOException {
		this.categoriaResidencial = CategoriaResidencial.fromString(type);
	}



	//Getters and Setters
	public TipoDeUsuario getTipoDeUsuario() {return CLIENTE;}

	public String getNombreYApellido() {
		return nombreYapellido;
	}

	public Dispositivo getPrimerDispositivo(){
		return this.dispositivos.get(0);
	}
	public int getTelefono() { return telefono; }

	@JsonProperty("telefono")
	public void setTelefono(int telefono) {
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
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


	public String getContrasena() { return this.contrasena;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public String getNombreUsuario() {
		return this.nombreDeUsuario;
	}
}