package exceptionDispositivo;

import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.Modulo;

public class NoSePuedeCalcularElConsumoException extends DispositivoInteligenteException {


    public NoSePuedeCalcularElConsumoException(DispositivoInteligente de){
        super(de);
        this.error = "NO SE PUEDE CALCULAR EL CONSUMO";
    }


    public NoSePuedeCalcularElConsumoException(DispositivoEstandar de){
        super(new Modulo(de));
        this.error = "NO SE PUEDE CALCULAR EL CONSUMO";
    }

}
