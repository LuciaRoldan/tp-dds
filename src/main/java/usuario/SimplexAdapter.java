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

import dispositivosConcretos.DispositivoConcreto;

public class SimplexAdapter {
	
	private static int posicion;
	private static double horasCorrientes;
	static List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();

	public static HashMap<DispositivoConcreto, Double> configuracionOptima(ArrayList<DispositivoConcreto> dispositivos, double maximoConsumo) {

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
	
	public static void ejecutarSimplex(ArrayList<DispositivoConcreto> dispositivos, double maximoConsumo) {
		
		HashMap<DispositivoConcreto, Double> configuracionOptima = SimplexAdapter.configuracionOptima(dispositivos, maximoConsumo);
		
		dispositivos.forEach(dispositivo -> {
							horasCorrientes = dispositivo.consumoCorriente()/ dispositivo.getPotencia();
							if(dispositivo.getConsumoIdeal() < horasCorrientes) {
								dispositivo.apagate();
							}
							});
		
	}

}