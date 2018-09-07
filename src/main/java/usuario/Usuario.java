package usuario;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeUsuario")
@JsonSubTypes({
		@JsonSubTypes.Type(value=Cliente.class, name="CLIENTE"),
		@JsonSubTypes.Type(value=Administrador.class, name="ADMINISTRADOR")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {

	public String 		 	 domicilio;
	public String 		 	 fechaDeAlta;
	public String 		 	 contrasena;
	public String 		     nombreDeUsuario;
	public String 		     nombreYApellido;
	public TipoDeUsuario     tipoDeUsuario;
	public Integer           tdu;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer           numeroDeUsuario;


	//////////////////////////// CONSTRUCTOR /////////////////////////////////////////////////////////////

	public void inicializar(String nombreYApellido, String domicilio, String fechaDeAlta, String nombreUsuario,
			String contrasena,TipoDeUsuario tipoDeUsuario) {
		this.nombreYApellido = nombreYApellido;
		this.domicilio 		 = domicilio;
		this.fechaDeAlta	 = fechaDeAlta;
		this.nombreDeUsuario = nombreUsuario;
		this.contrasena 	 = contrasena;
		this.tipoDeUsuario   = tipoDeUsuario;
	}


	/////////////////////////// GETTERS /////////////////////////////////////////////////////////////
	public Integer       getNumeroDeUsuario()                 { return this.numeroDeUsuario;                       }
	public String 	     getContrasena() 				      { return contrasena; 						  		   }
	public String        getDomicilio() 					  { return domicilio;						 		   }
	public String	     getNombreUsuario() 				  { return nombreDeUsuario; 				 		   }
	public String        getNombreYApellido()				  { return this.nombreYApellido;			 		   }
	public String        getFechaDeAlta() 					  { return this.fechaDeAlta;                           }
	public TipoDeUsuario getTipoDeUsuario()					  { return null;							 		   }

	/////////////////////////// SETTERS /////////////////////////////////////////////////////////////

	public void setContrasena(String contrasena) 		     { this.contrasena = contrasena;			 		   }
	public void setDomicilio(String domicilio) 			     { this.domicilio = domicilio; 				 		   }
	public void setNombreYApellido(String nombreYApellido)   { this.nombreYApellido = nombreYApellido;	 		   }
	public void setNombreUsuario(String nombreUsuario) 	     { this.nombreDeUsuario = nombreUsuario;	 		   }
	public void setFechaDeAlta(String fechaDeAlta) 		     { this.fechaDeAlta = fechaDeAlta; 			 		   }

}

