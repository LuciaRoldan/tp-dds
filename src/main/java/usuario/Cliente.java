package usuario;

import static usuario.TipoDeUsuario.CLIENTE;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;

import categoria.CategoriaResidencial;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;
import sensor.Sensor;

@Entity
public class Cliente extends Usuario {

	private double maximoConsumo;
	private int documento;
	private int telefono;
	private int puntos = 0;
	private Double consumoAnterior;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(nullable = true, name = "numeroDeUsuario", foreignKey = @ForeignKey(name = "numeroDeUsuario"))
	private List<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
	@Enumerated(EnumType.STRING)
	private CategoriaResidencial categoriaResidencial;
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(nullable = true, name = "numeroDeUsuario", foreignKey = @ForeignKey(name = "numeroDeUsuario"))
	private List<Sensor> sensores = new ArrayList<Sensor>();

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {}

	public Cliente(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreDeUsuario,
			String contrasena, TipoDocumento tipoDocumento, int documento, int telefono,
			CategoriaResidencial categoriaResidencial, ArrayList<DispositivoConcreto> dispositivos, Float coordenadaX, Float coordenadaY) {

		//dataBase = DataBase.getInstance();
		super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreDeUsuario, contrasena, CLIENTE, coordenadaX, coordenadaY);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefono = telefono;
		this.categoriaResidencial = categoriaResidencial;
		this.dispositivos = dispositivos;
		this.maximoConsumo = 612;
		
	}


	public Double calcularConsumoMensual() {

		Double consumo = dispositivos.stream()
									 .mapToDouble(dispositivo -> dispositivo.consumoMensual())
									 .sum();
		return consumo;
	}

	public Double calcularConsumoPeriodo(LocalDateTime inicio,LocalDateTime fin) {

		consumoAnterior = dispositivos.stream()
				.mapToDouble(dispositivo -> dispositivo.calcularConsumoPeriodo(inicio,fin))
				.sum();
		return consumoAnterior;
	}

	public String getConsumoAnterior(){
		this.calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1),LocalDateTime.now().minusMonths(2));
		DecimalFormat formatter = new DecimalFormat("#0.00");

		return formatter.format(consumoAnterior);
	}

	public String getConsumo() {

		Double consumo = dispositivos.stream()
				.mapToDouble(dispositivo -> dispositivo.consumoMensual())
				.sum();
		DecimalFormat formatter = new DecimalFormat("#0.00");

		return formatter.format(consumo);
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
	
	public void agregarSensor(Sensor sensor) {
		this.sensores.add(sensor);
	}

	// AL AGREGAR UN MODULO A UN DISPOTIVO ESTANDAR DEBE ESPECIFICARSE EL ESTADO INICIAL

	public void agregarModulo(DispositivoConcreto dispositivo, EstadoDispositivo estadoDispositivo) {
		if (this.getDispositivos().contains(dispositivo) && !dispositivo.esInteligente()) {
		dispositivo.agregarModulo(estadoDispositivo);
		this.puntos += 10;
		}
	}
	
	/*public void agregarDispositivoConcreto(DispositivoConcreto dispositivo) {
		this.dispositivos.add(dispositivo);
	}*/
	
	
	//CONFIGURACION OPTIMA DE DISPOSITIVOS
	
	public HashMap<DispositivoConcreto, Double> configuracionOptima(){ //falta implementacion
		HashMap<DispositivoConcreto, Double> configuracionOptima = SimplexAdapter.configuracionOptima(this.dispositivos, this.maximoConsumo);
		return configuracionOptima;
	}
	
	public void ejecutarSimplex() {
		SimplexAdapter.ejecutarSimplex(this.dispositivos, this.maximoConsumo);
	}
	
	public void ejecutarSimplexMock() {
		SimplexAdapter.ejecutarSimplexMock(this.dispositivos, this.maximoConsumo);
	}


	//REPORTES

	public double consumoHogarPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		return dispositivos.stream().
				mapToDouble(dispositivo -> dispositivo.calcularConsumoPeriodo(inicio, fin)).
				sum();
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

	public List<DispositivoConcreto> getDispositivos() {
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
	
	public List<Sensor>getSensores(){
		return this.sensores;
	}

	public String getNumeroDeUsuarioS(){ return String.valueOf(this.numeroDeUsuario); }

	public String getMaximoConsumoS(){ return String.valueOf(this.getMaximoConsumo()); }

	public String getConsumoMensualS(){ return String.valueOf(this.getConsumo()); }

	public String getCategoriaResidencialS(){ return this.getCategoriaResidencial().getNombre(); }

	
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
