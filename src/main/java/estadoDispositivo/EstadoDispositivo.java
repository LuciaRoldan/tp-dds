package estadoDispositivo;

import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;

import java.time.LocalDateTime;

public interface EstadoDispositivo {

	public boolean estaEncendido();

	public boolean estaApagado();

	public void apagate(DispositivoInteligenteConcreto dispositivo);

	public void encendete(DispositivoInteligente dispositivo);

	public void activarAhorroDeEnergia(DispositivoInteligenteConcreto dispositivoInteligenteConcreto);
	
	public Long calcularConsumo(Long kWh);

	public LocalDateTime getFin();

	public LocalDateTime getInicio();
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin);

	public Long calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, Long kWh);

	boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin);

}
