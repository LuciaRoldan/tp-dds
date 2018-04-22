package usuario;

import categorias.CategoriaResidencial;
import com.fasterxml.jackson.annotation.JsonProperty;
import dispositivos.Dispositivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static usuario.TipoDeUsuario.CLIENTE;

public class Cliente extends Usuario {

	private TipoDocumento tipoDocumento;
	private int documento;
	private int telefono;
	private CategoriaResidencial categoriaResidencial;
	private ArrayList<Dispositivo> dispositivos;

	/////////////////////////////////// CONSTRUCTORES /////////////////////////

	public Cliente() {
	}

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

	// ESTA FUNCION ES PARA EL PARSER
	@JsonProperty("categoriaResidencial")
	public void setType(String type) throws IOException {
		this.categoriaResidencial = CategoriaResidencial.fromString(type);
	}

	////////////////////////////////// GETTERS NECESARIOS PARA TESTS
	////////////////////////////////// /////////////////////////////////

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

	public int getCantidadDispositivos() {
		return dispositivos.size();
	}

	public List getDispositivosEncendidos() {
		return dispositivos.stream().filter(dispositivo -> dispositivo.isEncendido()).collect(Collectors.toList());
	}

	public int getSizeDispositivosEncendidos() {
		return this.getDispositivosEncendidos().size();
	}

	public int getSizeDispositivosApagados() {
		return (this.getCantidadDispositivos() - this.getSizeDispositivosEncendidos());
	}

	public Dispositivo getPrimerDispositivo() {
		return this.dispositivos.get(0);
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

	public boolean getAnyDispositivosEncendidos() {
		return this.getSizeDispositivosEncendidos() > 0;
	}

	/////////////////////////////////////////// SETTERS
	/////////////////////////////////////////// /////////////////////////////////////////////////////////////

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

	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Double calcularConsumoMensual() {

		List<Dispositivo> dispositivosEncendidos = this.getDispositivosEncendidos();
		Double consumo = dispositivosEncendidos.stream()
											   .mapToDouble(dispositivo -> dispositivo.getkWh())
											   .sum();
		return consumo;

	}

	public void recategorizarse() {

		CategoriaResidencial nuevaCategoria = this.categoriaResidencial.recategorizar(this.calcularConsumoMensual());
		this.setCategoriaResidencial(nuevaCategoria);
	}
}
