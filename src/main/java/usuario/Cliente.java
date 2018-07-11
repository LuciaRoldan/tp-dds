package usuario;

import static usuario.TipoDeUsuario.CLIENTE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;

public class Cliente extends Usuario {

	private TipoDocumento tipoDocumento;
	private int documento;
	private int telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
	private ArrayList<DispositivoEstandar> dispositivosEstandars = new ArrayList<DispositivoEstandar>();
	private int puntos = 0;

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {}

	public Cliente(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreDeUsuario,
			String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
			CategoriaResidencial categoriaResidencial, ArrayList<DispositivoInteligente> dispositivos,ArrayList<DispositivoEstandar> dispositivosEstandar) {

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
		this.setCategoriaResidencial(nuevaCategoria);
	}
	
	public int getCantidadDispositivos() {
		return dispositivos.size();
	}

	///////////////////////////// CORREGIR ESTA FUNCION /////////////////////////////////////
	public Long calcularConsumoAhora(){
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////
	
	public int cantidadDipositivosInteligentes() {
		return this.dispositivosInteligentes().size();
	}

	public List<DispositivoInteligente> getDispositivosEncendidos() {
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.estaEncendido()).collect(Collectors.toList());
	}

	public int getCantidadDispositivosEncendidos() {
		return this.getDispositivosEncendidos().size();
	}

	public int getCantidadDispositivosApagados() {
		return (this.cantidadDipositivosInteligentes() - this.getCantidadDispositivosEncendidos());
	}

	public DispositivoInteligente getPrimerDispositivo() {
		return this.dispositivos.get(0);
	}
	
	public boolean alMenosUnoEstaEncendido() {
		return this.getCantidadDispositivosEncendidos() > 0;
	}

	// AL AGREGAR UN MODULO A UN DISPOTIVO ESTANDAR DEBE ESPECIFICARSE EL ESTADO INICIAL

	public void agregarModulo(DispositivoEstandar dispositivo, EstadoDispositivo estadoDispositivo) {
		if (dispositivosEstandar().contains(dispositivo)) {
		dispositivos.add(new Modulo(dispositivo,estadoDispositivo));
		dispositivosEstandars.remove(dispositivo);
		this.puntos += 10;
		}
	}
	
	public List<DispositivoInteligente> dispositivosInteligentes(){
		return this.dispositivos;
	}
	
	public List<DispositivoEstandar> dispositivosEstandar() {
		return this.dispositivosEstandars;
	}
	


	////////////////////////////////// GETTERS NECESARIOS PARA TESTS //////////////////////////////////////////////////////

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

	public ArrayList<DispositivoInteligente> getDispositivosInteligentes() {
		return this.dispositivos;
	}

	public ArrayList<DispositivoEstandar> getDispositivosEstandar() {
		return this.dispositivosEstandars;
	}
	
	/////////////////////////////////////////// SETTERS /////////////////////////////////////////////////////////////

	public void setCategoriaResidencial(CategoriaResidencial cr) {
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

	public void setDispositivosInteligentes(ArrayList<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void setDispositivosEstandars(ArrayList<DispositivoEstandar> dispositivos) {
		this.dispositivosEstandars = dispositivos;
	}

}
