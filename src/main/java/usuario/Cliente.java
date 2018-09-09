package usuario;

import static usuario.TipoDeUsuario.CLIENTE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Transient;

import categoria.CategoriaResidencial;
import dataBase.DataBase;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;

@Entity
public class Cliente extends Usuario {

	private double maximoConsumo;
	private int documento;
	private int telefono;
	private int puntos = 0;
	private Integer numeroDeCliente;
	@ElementCollection
	private List<Integer> listaDeDispositivosID = new ArrayList<Integer>();
	@Transient
	private ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
	@Transient
	private CategoriaResidencial categoriaResidencial;
	@Transient
	private TipoDocumento tipoDocumento;
	@Transient
	private DataBase dataBase;

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {}

	public Cliente(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreDeUsuario,
			String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
			CategoriaResidencial categoriaResidencial, ArrayList<DispositivoConcreto> dispositivos, Float coordenadaX, Float coordenadaY) {

		dataBase = DataBase.getInstance();
		super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreDeUsuario, contrasena, CLIENTE, coordenadaX, coordenadaY);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
		this.maximoConsumo = 612;
		if (dispositivos != null) {
			for (DispositivoConcreto dc : dispositivos) {
				listaDeDispositivosID.add(dc.getId());
				dispositivos.add(dataBase.getDispositivo(dc.getId()));
			}
		}

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

	public Integer getNumeroDeCliente(){return this.numeroDeCliente;}

	
	public int getCantidadDispositivos() {
		return dispositivos.size();
	}

	///////////////////////////// CORREGIR ESTA FUNCION /////////////////////////////////////
	public Long calcularConsumoAhora(){
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////
	
	public int cantidadDipositivosInteligentes() {
		return this.getDispositivosInteligentes().size();
	}

	public List<DispositivoConcreto> getDispositivosEncendidos() {
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.estaEncendido()).collect(Collectors.toList());
	}

	public int getCantidadDispositivosEncendidos() {
		return this.getDispositivosEncendidos().size();
	}

	public int getCantidadDispositivosApagados() {
		return (this.cantidadDipositivosInteligentes() - this.getCantidadDispositivosEncendidos());
	}

	public DispositivoConcreto getPrimerDispositivo() {
		return this.dispositivos.get(0);
	}
	
	public boolean alMenosUnoEstaEncendido() {
		return this.getCantidadDispositivosEncendidos() > 0;
	}

	// AL AGREGAR UN MODULO A UN DISPOTIVO ESTANDAR DEBE ESPECIFICARSE EL ESTADO INICIAL

	public void agregarModulo(DispositivoConcreto dispositivo, EstadoDispositivo estadoDispositivo) {
		if (this.getDispositivos().contains(dispositivo) && !dispositivo.esInteligente()) {
		dispositivo.agregarModulo(estadoDispositivo);
		this.puntos += 10;
		}
	}
	
	
	//CONFIGURACION OPTIMA DE DISPOSITIVOS
	
	public HashMap<DispositivoConcreto, Double> configuracionOptima(){ //falta implementacion
		HashMap<DispositivoConcreto, Double> configuracionOptima = SimplexAdapter.configuracionOptima(this.dispositivos, this.maximoConsumo);
		return configuracionOptima;
	}
	
	public void ejecutarSimplex() {
		SimplexAdapter.ejecutarSimplex(this.dispositivos, this.maximoConsumo);
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

	public ArrayList<DispositivoConcreto> getDispositivos() {
		return this.dispositivos;
	}
	
	public List<DispositivoConcreto> getDispositivosInteligentes(){
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.esInteligente()).collect(Collectors.toList());
	}
	
	public List<DispositivoConcreto> getDispositivosEstandar() {
		return this.dispositivos.stream().filter(dispositivo -> !dispositivo.esInteligente()).collect(Collectors.toList());
	}
	
	public double getMaximoConsumo() {
		return maximoConsumo;
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

	public void setDispositivos(ArrayList<DispositivoConcreto> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void setMaximoConsumo(double maximoConsumo) {
		this.maximoConsumo = maximoConsumo;
	}
	
	
}
