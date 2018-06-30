package exceptionDispositivo.dispositivoInteligente;

import dispositivo.DispositivoInteligenteInterfaz;

import java.util.ArrayList;
import java.util.Date;

public class DispositivoInteligenteExeption extends RuntimeException {
    Date date;
    String error;
    dispositivo.DispositivoInteligenteInterfaz dispositivoInteligente;

    public DispositivoInteligenteExeption(dispositivo.DispositivoInteligenteInterfaz de,String error){
        this.dispositivoInteligente = de;
        this.date = new Date();
        this.error = error;
    }

}
