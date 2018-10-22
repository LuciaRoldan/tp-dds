package usuario;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.internal.CoreLogging;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeUsuario")
@JsonSubTypes({
		@JsonSubTypes.Type(value=Cliente.class, name="CLIENTE"),
		@JsonSubTypes.Type(value=Administrador.class, name="ADMINISTRADOR")
})


@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

	public String 		 	 domicilio;
	public LocalDate 		 fechaDeAlta;
	public String 		 	 contrasena;
	public String 		     nombreDeUsuario;
	public String 		     nombreYApellido;
	public TipoDeUsuario     tipoDeUsuario;
	public Integer           tdu;
	private Float coordenadaX;
    private Float coordenadaY;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer           numeroDeUsuario;


	//////////////////////////// CONSTRUCTOR /////////////////////////////////////////////////////////////

	public void inicializar(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, String nombreUsuario,
			String contrasena,TipoDeUsuario tipoDeUsuario, Float coordenadaX, Float coordenadaY) {
		this.nombreYApellido = nombreYApellido;
		this.domicilio 		 = domicilio;
		this.fechaDeAlta	 = fechaDeAlta;
		this.nombreDeUsuario = nombreUsuario;
		this.contrasena 	 = contrasena;
		this.tipoDeUsuario   = tipoDeUsuario;
		this.coordenadaX 	 = coordenadaX;
		this.coordenadaY 	 = coordenadaY;
	}


	/////////////////////////// GETTERS /////////////////////////////////////////////////////////////
	public Integer       getId()                              { return this.numeroDeUsuario;                       }
	public String 	     getContrasena() 				      { return contrasena; 						  		   }
	public String        getDomicilio() 					  { return domicilio;						 		   }
	public String	     getNombreUsuario() 				  { return nombreDeUsuario; 				 		   }
	public String        getNombreYApellido()				  { return this.nombreYApellido;			 		   }
	public LocalDate        getFechaDeAlta() 			      { return this.fechaDeAlta;                           }
	public TipoDeUsuario getTipoDeUsuario()					  { return null;							 		   }
	public Float 		 getCoordenadaX()					  { return coordenadaX;								   }
	public Float 		 getCoordenadaY()					  { return coordenadaY;								   }
	
	/////////////////////////// SETTERS /////////////////////////////////////////////////////////////

	public void setContrasena(String contrasena) 		     { this.contrasena = contrasena;			 		   }
	public void setDomicilio(String domicilio) 			     { this.domicilio = domicilio; 				 		   }
	public void setNombreYApellido(String nombreYApellido)   { this.nombreYApellido = nombreYApellido;	 		   }
	public void setNombreUsuario(String nombreUsuario) 	     { this.nombreDeUsuario = nombreUsuario;	 		   }
	public void setFechaDeAlta(LocalDate fechaDeAlta) 		 { this.fechaDeAlta = fechaDeAlta; 			 		   }
	public void setCoordenadaX(Float coordenadaX)			 { this.coordenadaX = coordenadaX;					   }
	public void setCoordenadaY(Float coordenadaY)			 { this.coordenadaY = coordenadaY;					   }

}

