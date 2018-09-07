package actuador;

import dispositivosConcretos.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public abstract class Actuador {

    @Id
    @GeneratedValue
    private Integer numeroDeActuador;
    DispositivoConcreto dispositivo;

    public Actuador(){};
    public Actuador(DispositivoConcreto dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();

}