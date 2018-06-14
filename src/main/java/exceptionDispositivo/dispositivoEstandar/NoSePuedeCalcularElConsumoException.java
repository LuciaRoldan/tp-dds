package exceptionDispositivo.dispositivoEstandar;

import dispositivo.DispositivoEstandar;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;

public class NoSePuedeCalcularElConsumoException extends DispositivoEstandarExeption {


    public NoSePuedeCalcularElConsumoException(DispositivoEstandar dispositivoEstandar ) {
        super(dispositivoEstandar,"NO SE PUEDE CALCULAR EL CONSUMO");
    }


}
