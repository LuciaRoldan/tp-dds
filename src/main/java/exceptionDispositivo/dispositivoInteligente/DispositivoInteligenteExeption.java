package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligenteAbstracto;

import java.util.Date;

public class DispositivoInteligenteExeption extends RuntimeException {
    Date date;
    String error;
    DispositivoInteligenteAbstracto dispositivoInteligente;

    public DispositivoInteligenteExeption(DispositivoInteligenteAbstracto de, String error){
        this.dispositivoInteligente = de;
        this.date = new Date();
        this.error = error;
    }

}
