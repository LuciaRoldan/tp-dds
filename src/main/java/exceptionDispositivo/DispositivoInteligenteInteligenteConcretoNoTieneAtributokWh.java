package exceptionDispositivo;

import dispositivo.DispositivoInteligente;

public class DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh extends DispositivoInteligenteException {

    public DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh(DispositivoInteligente de){
        super(de);
        this.error = "NO SE LE DEBE PEDIR EL ATRIBUTO kWh A ESTE DISPOSITIVO PORQUE ES INTELIGENTE CONCRETO";
    }

}
