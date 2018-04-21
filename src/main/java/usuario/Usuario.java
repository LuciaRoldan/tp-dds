package usuario;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeUsuario")
@JsonSubTypes({
		@JsonSubTypes.Type(value=Cliente.class, name="CLIENTE"),
		@JsonSubTypes.Type(value=Administrador.class, name="ADMINISTRADOR")
})
public abstract class Usuario {

	public String nombreYapellido ;
	public String domicilio;
	public String fechaDeAlta;
	public String contrasena;
	public String nombreDeUsuario;
	public String nombreYApellido;
	public TipoDeUsuario tipoDeUsuario;


	public void inicializar(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
			String contrasena,TipoDeUsuario tipoDeUsuario) {
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.nombreDeUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.tipoDeUsuario = tipoDeUsuario;
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


	public TipoDeUsuario getTipoDeUsuario() {return null;}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}
