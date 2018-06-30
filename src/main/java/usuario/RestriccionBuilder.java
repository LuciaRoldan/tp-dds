package usuario;

import java.util.ArrayList;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import dispositivo.DispositivoInteligenteInterfaz;

public class RestriccionBuilder {
	
	ArrayList<DispositivoInteligenteInterfaz> dispositivos;
	ArrayList<LinearConstraint> restricciones;
	ArrayList<Double> variables;
	
	public RestriccionBuilder(ArrayList<DispositivoInteligenteInterfaz> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void getRestricciones(ArrayList<DispositivoInteligenteInterfaz> dispositivos) {
		dispositivos.forEach(dispositivo -> this.crearRestricciones(dispositivo));
		
	}

	private LinearConstraint crearRestricciones(DispositivoInteligenteInterfaz dispositivo) {
		LinearConstraint restriccionMayorA = new LinearConstraint(dispositivo.getConsumoIdeal(), Relationship.GEQ, dispositivo.getConsumoMinimo());
		LinearConstraint restriccionMenosA = new LinearConstraint(dispositivo.getConsumoIdeal(), Relationship.LEQ, dispositivo.getConsumoMaximo());
	}

	public void getVariables(ArrayList<DispositivoInteligenteInterfaz> dispositivos) {
		// TODO Auto-generated method stub
		
	}

}
