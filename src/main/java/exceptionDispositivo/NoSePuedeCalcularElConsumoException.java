package exceptionDispositivo;

import modulo.Modulo;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;

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
