package dispositivo.estados;

import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;

import java.time.LocalDateTime;

public interface EstadoDispositivo {

	public boolean estaEncendido();

	public boolean estaApagado();

	public void apagate(DispositivoInteligente dispositivo);

	public void encendete(DispositivoInteligente dispositivo);

	public void activarAhorroDeEnergia(DispositivoInteligente dispositivoInteligenteConcreto);
	
	public Long calcularConsumo(Long kWh);

	public LocalDateTime getFin();

	public LocalDateTime getInicio();
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin);

	public Long calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, Long kWh);

	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin);

}
