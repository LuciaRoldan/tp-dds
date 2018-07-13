package testsActuadroesSensoresReglas;

import sensores.Sensor;
import reglas.CondicionTemperaturaAlta;
import reglas.CondicionVentanaAbierta;
import reglas.Regla;
import actuadores.AireEstadoActuador;
import reglas.Condicion;
import actuadores.Actuador;
import dispositivo.DispositivoInteligenteConcreto;
import dispositivo.estados.Apagado;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PrendemeElAire {

	@Test
	public void test() {
		Sensor sensorTemperatura = new Sensor();
		Sensor sensorVentana = new Sensor();
		CondicionTemperaturaAlta hacen30Grados = new CondicionTemperaturaAlta(sensorTemperatura, 30);
		CondicionVentanaAbierta estaCerrada = new CondicionVentanaAbierta(sensorVentana, false);
		DispositivoInteligenteConcreto aire = new DispositivoInteligenteConcreto("Aire acondicionado", new Apagado(), 10L);
		AireEstadoActuador actuadorAire = new AireEstadoActuador(aire,true);
		
		ArrayList<Actuador> actuadores = new ArrayList <Actuador>();
		ArrayList<Condicion> condiciones = new ArrayList <Condicion>();
		actuadores.add(actuadorAire);
		condiciones.add(hacen30Grados);
		condiciones.add(estaCerrada);
		
		new Regla(actuadores, condiciones);

		sensorVentana.cambiarMedicion(0);
		sensorTemperatura.cambiarMedicion(35);
		
		assertTrue(aire.estaEncendido());
	}

}
