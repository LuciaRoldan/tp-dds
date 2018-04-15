import java.time.LocalDate;

public class Administrador extends Usuario{
	String numeroDeIdentificacion;

	public String getNumeroDeIdentificacion() {
		return numeroDeIdentificacion;
	}

	Administrador(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena,
				  String numeroDeIdentificacion){
		super(nombreYApellido, domicilio, fechaDeAlta, nombreUsuario, contrasena);
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}
	
	
	
	//Getters and Setters
	public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}
	
}
