package exceptionDispositivo.dispositivoBuilder;

import dispositivo.DispositivoBuilder;

import java.util.Date;

public class NoSePuedeCrearDispEstandarException extends DispositivoBuilderException {
    DispositivoBuilder db;
    Date date;


    public NoSePuedeCrearDispEstandarException(DispositivoBuilder db){
        super(db,"NO SE PUEDE CREAR EL DISPOSITIVO ESTANDAR,ATRIBUTOS ERRONEOS");
        this.db = db;
        this.error = "ERROR AL CREAR DISPOSITIVO INTELIGENTE ";
    }
}