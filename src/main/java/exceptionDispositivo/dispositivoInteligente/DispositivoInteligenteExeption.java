package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligenteAbstracto;

import java.util.ArrayList;
import java.util.Date;

public class DispositivoInteligenteExeption extends RuntimeException {
    Date date;
    String error;
    dispositivo.DispositivoInteligenteAbstracto dispositivoInteligente;

    public DispositivoInteligenteExeption(dispositivo.DispositivoInteligenteAbstracto de,String error){
        this.dispositivoInteligente = de;
        this.date = new Date();
        this.error = error;
    }

}
