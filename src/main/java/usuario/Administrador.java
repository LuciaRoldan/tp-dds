package usuario;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Administrador extends Usuario{

	private Integer numeroDeIdentificacion;
	private String nombresYapellidos;
	private String nombreDeUsuario;

	@JsonCreator
	public void inicializarAdministrador(String nombreYApellido, String domicilio,LocalDate fechaDeAlta, String nombreUsuario,
										 String contrasena,int numeroDeIdentificacion){

		this.inicializarUsuario(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
		this.numeroDeIdentificacion = numeroDeIdentificacion;
		this.nombresYapellidos = nombreYApellido;
		this.nombreDeUsuario = nombreUsuario;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.numeroDeIdentificacion = numeroDeIdentificacion;
		this.contrasena = contrasena;
	}
	

	
	/////////////////////////////////  GETTERS AND SETTERS //////////////////////////////////////////////////////


	public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }
    
    
    /////////////////////////////////////////  METODOS //////////////////////////////////////////////////////////////
    
    public long mesesComoAdministrador() {
    	return this.getFechaDeAlta().until(LocalDate.now(), ChronoUnit.MONTHS);
    }

}
