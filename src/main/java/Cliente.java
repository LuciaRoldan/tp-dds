import java.time.LocalDate;
import java.util.ArrayList;

import Categorias.CategoriaResidencial;
import Dispositivos.Dispositivo;

public class Cliente extends Usuario{

	long numeroDocumento;
	TipoDocumento tipoDocumento;
	long documento;
	private long telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;
	
	public void inicializarCliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena, TipoDocumento tipoDocumento,long numeroDocumento, long telefono, CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos){
		
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
		int cantidadEncendidos = 0;
		for (Dispositivo dispositivo : dispositivos) {
			if(dispositivo.isEncendido()) {
				cantidadEncendidos += 1;
			}
		}
		return cantidadEncendidos;
	}
	
	public int cantidadDispositivosApagados() {
		int cantidadApagados = this.cantidadDispositivos() - this.cantidadDispositivosEncendidos();
		return cantidadApagados;
	}
	
	
	
}