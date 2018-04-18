import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Administrador extends Usuario{

	int numeroDeIdentificacion;



	Administrador(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena,
				  int numeroDeIdentificacion){

		this.inicializarUsuario(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
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
