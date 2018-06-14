package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligente;

import java.util.ArrayList;
import java.util.Date;

public class DispositivoInteligenteExeption extends RuntimeException {
    Date date;
    String error;
    dispositivo.DispositivoInteligente dispositivoInteligente;

    public DispositivoInteligenteExeption(dispositivo.DispositivoInteligente de,String error){
        this.dispositivoInteligente = de;
        this.date = new Date();
        this.error = error;
    }

}
