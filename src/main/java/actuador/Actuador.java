package actuador;

import dispositivosConcretos.*;

import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Actuador {

	@Transient
    public DispositivoConcreto dispositivo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer numeroDeActuador;

    public Actuador(){};
    public Actuador(DispositivoConcreto dispositivo) {
    	this.dispositivo = dispositivo;
    }
    
    public void setDispositivo(DispositivoConcreto dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();

}