package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoBase;
import dispositivo.DispositivoInteligente;

public class SimplexAdapter {
	
	public static HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima(ArrayList<DispositivoInteligenteInterfaz> dispositivos){
		
		HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima = new HashMap<DispositivoInteligenteInterfaz, Integer>();
		
		
		List<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		LinearObjectiveFunction funcionAOptimizar = new LinearObjectiveFunction(new double[] {200, 400}, 0);
		RestriccionBuilder restriccionBuilder = new RestriccionBuilder(dispositivos);
		
		restriccionBuilder.getRestricciones(dispositivos);
		restriccionBuilder.getVariables(dispositivos);
		
		
		
		
		return configuracionOptima;
	}
	
		
	public static void chequearConsumoMensual(ArrayList<DispositivoInteligente> dispositivos) {
		double Z,X1,X2,X3,X4,X5,X6,X7,X8;
		
		RealVector vector;
		vector.addToEntry(0, Z);
		vector.addToEntry(1, X1);
		vector.addToEntry(2, X2);
		vector.addToEntry(3, X3);
		vector.addToEntry(4, X4);
		vector.addToEntry(5, X5);
		vector.addToEntry(6, X6);
		vector.addToEntry(7, X7);
		vector.addToEntry(8, X8);
		
//		R1:
		LinearObjectiveFunction funcionAOptimizar = new LinearObjectiveFunction(vector,0);
//		R2:
		restricciones.add(new LinearConstraint([1.013 + 0.011 + 0.08+ 0.4 + 0.1275 + 0.64 + 0.75 + 0.06], Relationship.LEQ, 612));
//		R3:
		for (DispositivoInteligente dispositivoInteligente : dispositivos) {
//			tenemos el problema de que es inteligente y hay que cambiar el consumo maximo por que sea la potencia
			restricciones.add(new LinearConstraint(vector, Relationship.LEQ, dispositivoInteligente));
		}
		
	double[] arrayConsumosOptiomos = resultado.getPoint();
	Double horasTotales = resultado.getValue();
	
	int posicion = 0;
	
	for(double consumosOptimo : arrayConsumosOptimos) {
		dispositivos.get(posicion).setConsumoIdeal(consumoOptimo);
	}
	
	}
	
//	private ArrayList<Double> armaRestriccion(ArrayList<DispositivoInteligente> dispositivos) {
//	me va a agarrar dispositivos inteligentes
//	}
}
