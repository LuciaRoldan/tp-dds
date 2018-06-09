package exceptionDispositivo;

import adaptadorInteligente.AdaptadorInteligente;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;

public class NoSePuedeAgregarOtroModuloAdicional extends DispositivoInteligenteException{


    public NoSePuedeAgregarOtroModuloAdicional(DispositivoInteligente de){
        super(de);
        this.error = "ESTE DISPOSITIVO YA TIENE UN MODULO";
    }

}
