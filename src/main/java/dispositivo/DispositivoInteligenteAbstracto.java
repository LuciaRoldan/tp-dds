package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GenerationType;

import dispositivo.estados.EstadoDispositivo;

@Entity
public abstract class DispositivoInteligenteAbstracto extends DispositivoBase{
	

    public double consumoMensual() {
        return 0;
    }

    public void activarAhorroDeEnergia() {

    }

    public void agregarEstado(EstadoDispositivo estado) {

    }

    public void setEstado(EstadoDispositivo estado) {

    }

    public void apagate() {

    }

    public void encendete() {

    }

    public boolean estaEncendido() {
        return false;
    }

    public boolean estaApagado() {
        return false;
    }

    public EstadoDispositivo getEstado() {
        return null;
    }

    public double calcularConsumoUltimasNHoras(int horas) {
        return 0;
    }

    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        return 0;
    }

    public double consumoCorriente() {
        return 0;
    }

    ///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

    public double getPotencia() {
        return 0;
    }

    public String getName() {
        return null;
    }

    //////////////////////////////////// SETTERS ////////////////////////////////////

    public void setName(String name) {

    }

    public void setPotencia(double potencia) {

    }
}
