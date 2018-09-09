package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public interface DispositivoBase {
	
    public double consumoMensual();
    public void activarAhorroDeEnergia();
    public void setEstado(EstadoDispositivo estado);
    public void apagate();
    public void encendete();
    public boolean estaEncendido();
    public boolean estaApagado() ;
    public EstadoDispositivo getEstado() ;
    public double calcularConsumoUltimasNHoras(int horas);
    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin);
    public boolean esInteligente();	
    public double consumoCorriente();
    public double consumoPromedioPorHora(LocalDateTime inicio, LocalDateTime fin);
    
    //////////GETTERS//////////
    
    public String getName();
    public double getPotencia();
    public double getUsoMensualMinimo();
    public double getUsoMensualMaximo();
    public double getHorasDeUsoIdeal();
    
    //////////SETTERS//////////
    
    public void setName(String name);
    public void setPotencia(double potencia);
	public void setBajoConsumo(boolean bajoConsumo);
	public void agregarEstado(EstadoDispositivo estado);

}
