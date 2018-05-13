package usuario;

import static usuario.TipoDeUsuario.CLIENTE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;


import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;

public class Cliente extends Usuario {

	private TipoDocumento tipoDocumento;
	private int documento;
	private int telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;
	private int puntos = 0;

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {}

	public Cliente(String nombreYapellido, String domicilio, String fechaDeAlta, String nombreDeUsuario,
			String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
			CategoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos) {

		super.inicializar(nombreYApellido, fechaDeAlta, nombreDeUsuario, nombreDeUsuario, contrasena, CLIENTE);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
	}
	
	public Double calcularConsumoMensual() {

		Double consumo = dispositivos.stream()
									 .mapToDouble(dispositivo -> dispositivo.consumoMensual())
									 .sum();
		return consumo;
	}

	public void recategorizarse() {

		CategoriaResidencial nuevaCategoria = this.categoriaResidencial.recategorizar(this.calcularConsumoMensual());
		this.setCategoriaResidencial2(nuevaCategoria);
	}
	
	public int getCantidadDispositivos() {
		return dispositivos.size();
	}
	
	public int cantidadDipositivosInteligentes() {
		return this.dispositivosInteligentes().size();
	}

	public List<Dispositivo> getDispositivosInteligentesEncendidos() {
		return this.dispositivosInteligentes().stream().filter(dispositivo -> dispositivo.isEncendido()).collect(Collectors.toList());
	}

	public int getCantidadDispositivosInteligentesEncendidos() {
		return this.getDispositivosInteligentesEncendidos().size();
	}

	public int getCantidadDispositivosInteligentesApagados() {
		return (this.cantidadDipositivosInteligentes() - this.getCantidadDispositivosInteligentesEncendidos());
	}

	public Dispositivo getPrimerDispositivo() {
		return this.dispositivos.get(0);
	}
	
	public boolean alMenosUnoEstaEncendido() {
		return this.getCantidadDispositivosInteligentesEncendidos() > 0;
	}

	public void agregarModulo(Dispositivo dispositivo) {
		if (dispositivosEstandar().contains(dispositivo)) {
		dispositivo.agregarModulo();
		this.puntos += 10;
		}
	}
	
	public List<Dispositivo> dispositivosInteligentes(){
		return dispositivos.stream().filter(dispositivo -> dispositivo.esInteligente()).collect(Collectors.toList());
	}
	
	public List<Dispositivo> dispositivosEstandar() {
		return dispositivos.stream().filter(dispositivo -> !dispositivo.esInteligente()).collect(Collectors.toList());
	}
	


	////////////////////////////////// GETTERS NECESARIOS PARA TESTS //////////////////////////////////////////////////////

	public String getContrasena() {
		return this.contrasena;
	}

	public String getNombreYApellido() {
		return nombreYapellido;
	}

	public String getNombreUsuario() {
		return this.nombreDeUsuario;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getDocumento() {
		return documento;
	}


	public CategoriaResidencial getCategoriaResidencial() {
		return categoriaResidencial;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return CLIENTE;
	}

	public ArrayList<Dispositivo> getDispositivos() {
		return this.dispositivos;
	}

	
	/////////////////////////////////////////// SETTERS /////////////////////////////////////////////////////////////

	public void setCategoriaResidencial2(CategoriaResidencial cr) {
		this.categoriaResidencial = cr;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	// ESTA FUNCION ES PARA EL PARSER
	@JsonProperty("categoriaResidencial")
	public void setType(String type) throws IOException {
		this.categoriaResidencial = CategoriaResidencial.fromString(type);
	}
}
