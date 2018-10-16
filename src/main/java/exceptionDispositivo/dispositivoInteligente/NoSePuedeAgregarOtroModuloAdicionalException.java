package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligenteAbstracto;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

public class NoSePuedeAgregarOtroModuloAdicionalException extends DispositivoInteligenteExeption {


    public NoSePuedeAgregarOtroModuloAdicionalException(DispositivoInteligenteAbstracto de){
        super(de,"ESTE DISPOSITIVO YA TIENE UN MODULO");
    }

}
