import java.sql.Date;
import java.time.LocalDate;

public abstract class Usuario {
	String nombreYApellido;
	String domicilio;
	LocalDate fechaDeAlta;
	String nombreUsuario;
	String contrasena;
	
	Usuario(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario, String contrasena){
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}


	
	
	
	
	//Getters and Setters
	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
