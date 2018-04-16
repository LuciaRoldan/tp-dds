import java.time.LocalDate;

public class Administrador extends Usuario{

	int numeroDeIdentificacion;



	Administrador(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena,
				  int numeroDeIdentificacion){

		super(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}
	

	
	/////////////////////////////////  GETTERS AND SETTERS //////////////////////////////////////////////////////


	public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

}
