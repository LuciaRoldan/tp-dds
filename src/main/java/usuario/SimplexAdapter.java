package usuario;

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

	static List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();

	public static double[] chequearConsumoMensual(ArrayList<DispositivoConcreto> dispositivos, double maximoConsumo) {

		double array[] = new double[dispositivos.size()];
		Arrays.fill(array, 1);
		LinearObjectiveFunction funcionAOptimizar = new LinearObjectiveFunction(array, 0);
		RestriccionBuilder restriccionBuilder = new RestriccionBuilder(dispositivos, maximoConsumo);
		SimplexSolver simplex = new SimplexSolver();

		restricciones = restriccionBuilder.getRestricciones();

		PointValuePair resultado = simplex.optimize(new MaxIter(100), funcionAOptimizar,
				new LinearConstraintSet(restricciones), GoalType.MAXIMIZE, new NonNegativeConstraint(true));

		double[] arrayConsumosOptimos = resultado.getPoint();
		double horasTotales = resultado.getValue();
		int posicion = 0;

		for (double consumoOptimo : arrayConsumosOptimos) {
			dispositivos.get(posicion).setConsumoIdeal(consumoOptimo);
		}

		return arrayConsumosOptimos;

	}

}
