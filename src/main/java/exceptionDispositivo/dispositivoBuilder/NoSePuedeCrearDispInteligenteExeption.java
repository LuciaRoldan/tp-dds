package exceptionDispositivo.dispositivoBuilder;

import dispositivo.DispositivoBuilder;
import exceptionDispositivo.dispositivoInteligente.DispositivoInteligenteExeption;

import java.util.Date;

public class NoSePuedeCrearDispInteligenteExeption extends DispositivoBuilderException {
    DispositivoBuilder db;
    Date date;


    public NoSePuedeCrearDispInteligenteExeption(DispositivoBuilder db){
        super(db,"NO SE PUEDE CREAR DISPOSITIVO INTELIGENTE, ATRIBUTOS ERRONEOS");
        this.db = db;
        this.error = "ERROR AL CREAR DISPOSITIVO INTELIGENTE ";
    }
}