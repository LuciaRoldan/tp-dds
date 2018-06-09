package exceptionDispositivo;

import adaptadorInteligente.AdaptadorInteligente;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;

public class NoSePuedeCalcularElConsumoException extends DispositivoInteligenteException {


    public NoSePuedeCalcularElConsumoException(DispositivoInteligente de){
        super(de);
        this.error = "NO SE PUEDE CALCULAR EL CONSUMO";
    }


    public NoSePuedeCalcularElConsumoException(DispositivoEstandar de){
        super(new AdaptadorInteligente(de));
        this.error = "NO SE PUEDE CALCULAR EL CONSUMO";
    }

}
