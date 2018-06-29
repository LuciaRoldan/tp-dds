package dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public interface DispositivoBase {
	
    public Long consumoMensual();
    public void activarAhorroDeEnergia();
    public void setEstado(EstadoDispositivo estado);
    public void apagate();
    public void encendete();
    public boolean estaEncendido();
    public boolean estaApagado() ;
    public EstadoDispositivo getEstado() ;
    public Long calcularConsumoUltimasNHoras(Long horas);
    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin);
    public boolean esInteligente();	
    
    
    //////////GETTERS//////////
    
    public Long getkWh();
    public String getName();
    
    //////////SETTERS//////////
    
    public void setName(String name);
    public void setkWh(Long kWh);
	public void setBajoConsumo(boolean bajoConsumo);
	public void agregarEstado(EstadoDispositivo estado);
	

}
