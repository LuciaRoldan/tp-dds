package usuario;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Administrador extends Usuario{

	private Integer numeroDeIdentificacion;

	public Administrador(){

	}
	@JsonCreator
	public Administrador(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
						 String contrasena, Integer numeroDeIdentificacion){
					super.inicializar(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
			this.numeroDeIdentificacion = numeroDeIdentificacion;
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
