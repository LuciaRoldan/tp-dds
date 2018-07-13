package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligenteInterfaz;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

public class NoSePuedeAgregarOtroModuloAdicionalException extends DispositivoInteligenteExeption {


    public NoSePuedeAgregarOtroModuloAdicionalException(DispositivoInteligenteInterfaz de){
        super(de,"ESTE DISPOSITIVO YA TIENE UN MODULO");
    }

}
