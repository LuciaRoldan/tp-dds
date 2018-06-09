package exceptionDispositivo;

import adaptadorInteligente.AdaptadorInteligente;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;

public class NoSePuedeConocerElEstadoDelEstandarException extends DispositivoInteligenteException {

    public NoSePuedeConocerElEstadoDelEstandarException(DispositivoInteligente de){
        super(de);
        this.error = "NO SE DEBE PREGUNTAR EL ESTADO A ESTE DISPOSITIVO ";
    }
}
