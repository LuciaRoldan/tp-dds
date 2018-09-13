package exceptionDispositivo.dispositivoEstandar;

import dispositivo.DispositivoEstandar;

import java.util.Date;

public class DispositivoEstandarExeption extends RuntimeException {
    Date date;
    String error;
    DispositivoEstandar dispositivoEstandar;

    public DispositivoEstandarExeption(DispositivoEstandar de, String error){
        this.dispositivoEstandar = de;
        this.date = new Date();
        this.error = error;
    }

}
