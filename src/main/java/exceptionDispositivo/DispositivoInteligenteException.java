package exceptionDispositivo;

import dispositivo.DispositivoInteligente;

import java.util.ArrayList;
import java.util.Date;

public class DispositivoInteligenteException extends RuntimeException {
    Date date;
    String error;
    DispositivoInteligente dispositivoInteligente;

    public DispositivoInteligenteException(DispositivoInteligente de){
        this.dispositivoInteligente = de;
        date = new Date();
    }

}
