package testsDispositivo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoFactory;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import dispositivosConcretos.Heladera;
import mock.EncendidoMock;

public class ClasesParaTestearDispositivos {
	
	public EstadoDispositivo unEstadoEncendido() {
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime maniana = ahora.plus(1,ChronoUnit.DAYS);
		LocalDateTime haceUnMes = ahora.minus(1, ChronoUnit.MONTHS);
		
		return new EncendidoMock(haceUnMes, maniana);
	}

	public DispositivoInteligente unDispositivoInteligente() {
		
		EstadoDispositivo encendido = unEstadoEncendido();
		DispositivoInteligente dispositivo = new DispositivoInteligente("nombre", encendido, 200, 2000);
		
		return dispositivo;
	}

	public DispositivoConcreto unDispositivoConcretoConFactory() {
		
		EstadoDispositivo encendido = unEstadoEncendido();
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("aire");
		AireAcondicionado aire = factory.crearAireAcondicionado(3500);
		aire.setEstado(encendido);
		
		return aire;
	}
	
	public DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar("Nombre loco", 200, 2000, 40));
	}
	
	public DispositivoConcreto heladeraConFactory() {
		
		EstadoDispositivo encendido = unEstadoEncendido();
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("heladera");
		Heladera heladera = factory.crearHeladeraSinFreezer();
		heladera.setEstado(encendido);
		heladera.setPotencia(0.075);
		
		return heladera;
		
	} 
}
