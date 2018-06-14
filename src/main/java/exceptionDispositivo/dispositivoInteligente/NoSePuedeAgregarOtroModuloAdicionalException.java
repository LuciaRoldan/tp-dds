package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligente;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

public class NoSePuedeAgregarOtroModuloAdicionalException extends DispositivoInteligenteExeption {


    public NoSePuedeAgregarOtroModuloAdicionalException(DispositivoInteligente de){
        super(de,"ESTE DISPOSITIVO YA TIENE UN MODULO");
    }

}
