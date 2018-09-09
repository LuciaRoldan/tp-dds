package usuario;
import static usuario.TipoDeUsuario.ADMINISTRADOR;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Administrador extends Usuario{

	private Integer numeroDeIdentificacion;

	//////////////////////////////// CONSTRUCTORES /////////////////////////////////////////////////////////////

	public Administrador(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
						 String contrasena, Integer numeroDeIdentificacion, Float coordenadaX, Float coordenadaY){
					super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena, ADMINISTRADOR, coordenadaX, coordenadaY);
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
