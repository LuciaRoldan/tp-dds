package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.SimplexSolver;

import dispositivo.DispositivoInteligenteInterfaz;

public class SimplexAdapter {
	
	public static HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima(ArrayList<DispositivoInteligenteInterfaz> dispositivos){
		
		HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima = new HashMap<DispositivoInteligenteInterfaz, Integer>();
		
		SimplexAdapter solver = new SimplexAdapter();
		
		LinearObjectiveFunction funcionAOptimizar = new LinearObjectiveFunction(new double[] {200, 400}, 0);
		RestriccionBuilder restriccionBuilder = new RestriccionBuilder(dispositivos);
		
		restriccionBuilder.getRestricciones(dispositivos);
		restriccionBuilder.getVariables(dispositivos);
		
		
		
		
		return configuracionOptima;
	}
	
	public static void chequearConsumoMensual(ArrayList<DispositivoInteligenteInterfaz> dispositivos) {
		
		HashMap<DispositivoInteligenteInterfaz, Integer> configuracionOptima = configuracionOptima(dispositivos);
		
	}
}
