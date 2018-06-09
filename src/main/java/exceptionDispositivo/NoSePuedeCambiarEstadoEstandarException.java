package exceptionDispositivo;

import adaptadorInteligente.AdaptadorInteligente;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;

public class NoSePuedeCambiarEstadoEstandarException extends  DispositivoInteligenteException{


    public NoSePuedeCambiarEstadoEstandarException(DispositivoInteligente de){
        super(de);
        this.error = "NO SE PUEDE CAMBIAR EL ESTADO DEL ESTANDAR";
    }
}
