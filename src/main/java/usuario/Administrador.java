package usuario;
import static usuario.TipoDeUsuario.ADMINISTRADOR;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;


public class Administrador extends Usuario{

	// Lo comento porque ahora es el numero de usuario private Integer numeroDeIdentificacion;

	//////////////////////////////// CONSTRUCTORES /////////////////////////////////////////////////////////////

	public Administrador(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario,
						 String contrasena, Float coordenadaX, Float coordenadaY){
					super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena, ADMINISTRADOR, coordenadaX, coordenadaY);
	}
	
	/////////////////////////////////  SETTERS //////////////////////////////////////////////////////

   //	public void setNumeroDeIdentificacion(int numeroDeIdentificacion) { re	this.getId();}

    /////////////////////////////////////////  GETTERS //////////////////////////////////////////////////////////////

	public float cantidadMesesComoAdministrador() {
    	return this.getFechaDeAlta().until(LocalDate.now(), ChronoUnit.MONTHS);

    }

	public int getNumeroDeIdentificacion() {
		return this.getId();
	}
	public TipoDeUsuario getTipoDeUsuario()			 { return ADMINISTRADOR;}
	
	
	@JsonCreator
	public Administrador(){}
}
