package usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import actuador.EncenderActuador;
import dispositivosConcretos.DispositivoConcreto;
import regla.CondicionConsumoSuperior;
import regla.Regla;
import sensor.Sensor;
import actuador.Actuador;
import regla.Condicion;

public class SimplexAdapter {
	
	private static int posicion;
	private static double horasCorrientes;
	static List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();

	public static HashMap<DispositivoConcreto, Double> configuracionOptima(List<DispositivoConcreto> dispositivos, double maximoConsumo) {

		SimplexSolver simplex = new SimplexSolver();		
		
		HashMap<DispositivoConcreto, Double> configuracionOptima = new HashMap<DispositivoConcreto, Double>();
		
		double array[] = new double[dispositivos.size()];
		Arrays.fill(array, 1);
		LinearObjectiveFunction funcionAOptimizar = new LinearObjectiveFunction(array, 0);
		
		restricciones = RestriccionBuilder.getRestricciones(dispositivos, maximoConsumo);

		PointValuePair resultado = simplex.optimize(new MaxIter(100), funcionAOptimizar,
				new LinearConstraintSet(restricciones), GoalType.MAXIMIZE, new NonNegativeConstraint(true));

		double horasTotales = resultado.getValue();
		
		double[] arrayConsumosOptimos = resultado.getPoint();
		
		posicion = 0;
		
		dispositivos.forEach(dispositivo -> {
							double consumoOptimo = arrayConsumosOptimos[posicion];
							dispositivo.setConsumoIdeal(consumoOptimo);
							configuracionOptima.put(dispositivos.get(posicion), consumoOptimo);
							posicion++;
							});

		return configuracionOptima;
		
	}
	
	public static void ejecutarSimplex(List<DispositivoConcreto> dispositivos, double maximoConsumo) {
		
		SimplexAdapter.configuracionOptima(dispositivos, maximoConsumo);
		
		/*dispositivos.forEach(dispositivo -> {
							horasCorrientes = dispositivo.consumoCorriente()/ dispositivo.getPotencia();
								if(dispositivo.getConsumoIdeal() < horasCorrientes) {
								dispositivo.apagate();
								}
		});
		*/
		dispositivos.forEach(dispositivo -> {
			EncenderActuador actuador = new EncenderActuador(dispositivo, false);
			List<Actuador> actuadores = new ArrayList<Actuador>();
			actuadores.add(actuador);
			
			Sensor sensor = new Sensor();
			
			CondicionConsumoSuperior condicion = new CondicionConsumoSuperior(sensor, dispositivo.getConsumoIdeal());
			List<Condicion> condiciones = new ArrayList<Condicion>();
			condiciones.add(condicion);
			
			new Regla(actuadores, condiciones);
			
			sensor.cambiarMedicion(dispositivo.consumoCorriente() / dispositivo.getPotencia());
			
		});
		
	}
	
	public static void ejecutarSimplexMock(List<DispositivoConcreto> dispositivos, double maximoConsumo) {
		
		SimplexAdapter.configuracionOptima(dispositivos, maximoConsumo);
		
		/*dispositivos.forEach(dispositivo -> {
							horasCorrientes = dispositivo.consumoCorriente()/ dispositivo.getPotencia();
								if(dispositivo.getConsumoIdeal() < horasCorrientes) {
								dispositivo.apagate();
								}
		});
		*/
		dispositivos.forEach(dispositivo -> {
			EncenderActuador actuador = new EncenderActuador(dispositivo, false);
			List<Actuador> actuadores = new ArrayList<Actuador>();
			actuadores.add(actuador);
			
			Sensor sensor = new Sensor();
			
			CondicionConsumoSuperior condicion = new CondicionConsumoSuperior(sensor, dispositivo.getConsumoIdeal());
			List<Condicion> condiciones = new ArrayList<Condicion>();
			condiciones.add(condicion);
			
			new Regla(actuadores, condiciones);
			
			sensor.cambiarMedicion(dispositivo.consumoCorrienteMock() / dispositivo.getPotencia());
			
		});
		
	}

}