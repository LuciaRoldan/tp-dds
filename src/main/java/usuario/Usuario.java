package usuario;

import java.time.LocalDate;

public abstract class Usuario {

	public String nombreYapellido ;
	public String domicilio;
	public String fechaDeAlta;
	public String contrasena;
	public String nombreDeUsuario;
	public String nombreYApellido;



	public void inicializar(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
			String contrasena) {
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.nombreDeUsuario = nombreUsuario;
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
		return LocalDate.parse(this.fechaDeAlta);
	}

	public void setFechaDeAlta(String fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public String getNombreUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreDeUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}
