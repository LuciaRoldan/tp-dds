package exceptionDispositivo.dispositivoEstandar;

import dispositivo.DispositivoEstandar;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

public class NoSePuedeCambiarEstadoEstandarException extends DispositivoEstandarExeption {


    public NoSePuedeCambiarEstadoEstandarException(DispositivoEstandar dispositivoEstandar){
        super(dispositivoEstandar,"NO SE PUEDE CAMBIAR EL ESTADO DEL ESTANDAR");
    }
}
