package exceptionDispositivo.dispositivoBuilder;

import dispositivo.DispositivoBuilder;

import java.util.Date;

public class DispositivoBuilderException extends RuntimeException {
    Date date;
    String error;
    DispositivoBuilder dispositivoBuilder;

    public DispositivoBuilderException(DispositivoBuilder dispositivoBuilder,String error){
        this.dispositivoBuilder = dispositivoBuilder;
        this.date = new Date();
        this.error = error;
    }


}
