package usuario;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static usuario.TipoDeUsuario.ADMINISTRADOR;


public class Administrador extends Usuario{

	private Integer numeroDeIdentificacion;

	//////////////////////////////// CONSTRUCTORES /////////////////////////////////////////////////////////////

	public Administrador(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
						 String contrasena, Integer numeroDeIdentificacion){
					super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena, ADMINISTRADOR);
			this.numeroDeIdentificacion = numeroDeIdentificacion;
	}

	/////////////////////////////////  SETTERS //////////////////////////////////////////////////////

	public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {	this.numeroDeIdentificacion = numeroDeIdentificacion;}

    /////////////////////////////////////////  GETTERS //////////////////////////////////////////////////////////////

	public float cantidadMesesComoAdministrador() {
    	//return this.getFechaDeAlta().until(LocalDate.now(), ChronoUnit.MONTHS);
        System.out.print("Soy el colo, hice que la fecha sea un String para que Hibernate no rompa,lo tengo que areglar");
        return -100000;
    }

	public int getNumeroDeIdentificacion() {
		return numeroDeIdentificacion;
	}
	public TipoDeUsuario getTipoDeUsuario()			 { return ADMINISTRADOR;}
	
	
	@JsonCreator
	public Administrador(){}
}
