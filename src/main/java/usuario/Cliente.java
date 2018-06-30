package usuario;

import static usuario.TipoDeUsuario.CLIENTE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;

public class Cliente extends Usuario {

	private TipoDocumento tipoDocumento;
	private int documento;
	private int telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
	private int puntos = 0;

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {}

	public Cliente(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreDeUsuario,
			String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
			CategoriaResidencial categoriaResidencial, ArrayList<DispositivoConcreto> dispositivos) {

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
	
	public HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima(){ //falta implementacion
		HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima = SimplexAdapter.configuracionOptima(this.dispositivos);
		return configuracionOptima;
	}
	
	public void ejecutarSimplex() {
		SimplexAdapter.chequearConsumoMensual(this.dispositivos);
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
}
