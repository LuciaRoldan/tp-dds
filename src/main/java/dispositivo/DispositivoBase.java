package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dispositivo.estados.Encendido;
import dispositivo.estados.EstadoDispositivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DispositivoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer numeroDeDispositivoBase;

    public double consumoMensual(){return -800;};
    public void activarAhorroDeEnergia(){};
    public void setEstado(EstadoDispositivo estado){};
    public void apagate(){};
    public void encendete(){};
    public boolean estaEncendido(){return false;};
    public boolean estaApagado(){return false;};
    public EstadoDispositivo getEstado(){return new Encendido();};
    public double calcularConsumoUltimasNHoras(int horas){return -100;};
    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin){return -200;};
    public boolean esInteligente(){return false;};
    public double consumoCorriente(){return -300;};

    //////////GETTERS//////////

    public String getName(){return "ERROR";};
    public double getPotencia(){return -400;};
    public double getUsoMensualMinimo(){return -500;};
    public double getUsoMensualMaximo(){return -600;};
    public double getHorasDeUsoIdeal(){return -700;};
    public List<EstadoDispositivo> getEstadosAnteriores() {return null;}

    //////////SETTERS//////////

    public void setName(String name){};
    public void setPotencia(double potencia){};
    public void setBajoConsumo(boolean bajoConsumo){};
    public void agregarEstado(EstadoDispositivo estado){};

}
