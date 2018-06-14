package exceptionDispositivo.dispositivoEstandar;

import dispositivo.DispositivoEstandar;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

public class NoSePuedeConocerElEstadoDelEstandarException extends DispositivoEstandarExeption {

    public NoSePuedeConocerElEstadoDelEstandarException(DispositivoEstandar dispositivoEstandar){
        super(dispositivoEstandar,"NO SE PUEDE PREGUNTAR EL ESTADO A ESTE DISPOSITIVO " );
    }
}
