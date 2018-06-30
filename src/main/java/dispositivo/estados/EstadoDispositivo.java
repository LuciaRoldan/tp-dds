package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import java.time.LocalDateTime;

public interface EstadoDispositivo {

	public boolean estaEncendido();

	public boolean estaApagado();

	public void apagate(DispositivoInteligenteInterfaz dispositivo);

	public void encendete(DispositivoInteligenteInterfaz dispositivo);

	public void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivoInteligenteConcreto);
	
	public Long calcularConsumo(Long kWh);

	public LocalDateTime getFin();

	public LocalDateTime getInicio();
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin);

	public Long calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, Long kWh);

	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin);

}
