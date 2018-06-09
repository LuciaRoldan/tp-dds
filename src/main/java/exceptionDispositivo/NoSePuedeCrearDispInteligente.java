package exceptionDispositivo;

import dispositivo.DispositivoBuilder;

import java.util.Date;

public class NoSePuedeCrearDispInteligente extends DispositivoInteligenteException {
    DispositivoBuilder db;
    Date date;


    public NoSePuedeCrearDispInteligente(DispositivoBuilder db){
        super(null);
        this.db = db;
        this.error = "ERROR AL CREAR DISPOSITIVO INTELIGENTE ";
    }
}