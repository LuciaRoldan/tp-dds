package adaptadorInteligente;

import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import estadoDispositivo.EstadoDispositivo;
import exceptionDispositivo.NoSePuedeAgregarOtroModuloAdicional;
import exceptionDispositivo.NoSePuedeCambiarEstadoEstandarException;
import exceptionDispositivo.NoSePuedeConocerElEstadoDelEstandarException;

public class AdaptadorInteligente implements DispositivoInteligente {

    DispositivoEstandar dispositivoEstandar;

    public AdaptadorInteligente(DispositivoEstandar de){
        this.dispositivoEstandar = de;
    }

    public void agregarEstado(EstadoDispositivo estado){throw new NoSePuedeCambiarEstadoEstandarException(this);}
    public Long consumoMensual(){return (Long.valueOf(30*this.dispositivoEstandar.getHorasDeUsoPorDia()));}
    public void agregarModulo(){throw new NoSePuedeAgregarOtroModuloAdicional(this);}
    public void encendete(){throw new NoSePuedeCambiarEstadoEstandarException(this);}
    public void apagate(){throw new NoSePuedeCambiarEstadoEstandarException(this);}
    public void activarAhorroDeEnergia(){throw new NoSePuedeCambiarEstadoEstandarException(this);}
    public boolean estaEncendido(){throw new NoSePuedeConocerElEstadoDelEstandarException(this);}
    public boolean estaApagado(){throw new NoSePuedeConocerElEstadoDelEstandarException(this);} ;
    public EstadoDispositivo getEstado(){throw new NoSePuedeConocerElEstadoDelEstandarException(this);};

    ///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

    public Long 					getkWh(){return this.dispositivoEstandar.getHorasDeUsoPorDia();}
    public String 					getName(){return this.dispositivoEstandar.getName();}

    //////////////////////////////////// SETTERS ////////////////////////////////////

    public void 					setNombre(String nombre){this.dispositivoEstandar.setName(nombre);}
    public void 					setkWh(Long kWh){this.dispositivoEstandar.setHorasDeUsoPorDia(kWh);}

}
