package dispositivo.estados;

import dispositivo.DispositivoInteligenteAbstracto;

import java.time.LocalDateTime;

public interface EstadoDispositivo {

	public boolean estaEncendido();

	public boolean estaApagado();

	public void apagate(DispositivoInteligenteAbstracto dispositivo);

	public void encendete(DispositivoInteligenteAbstracto dispositivo);

	public void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivoInteligenteConcreto);
	
	public double calcularConsumo(double potencia);

	public LocalDateTime getFin();

	public LocalDateTime getInicio();
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin);

	public double calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, double potencia);

	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin);

}
