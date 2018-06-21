package usuario;

import java.util.ArrayList;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import dispositivo.DispositivoInteligente;

public class RestriccionBuilder {
	
	ArrayList<DispositivoInteligente> dispositivos;
	ArrayList<LinearConstraint> restricciones;
	ArrayList<Double> variables;
	
	public RestriccionBuilder(ArrayList<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void getRestricciones(ArrayList<DispositivoInteligente> dispositivos) {
		dispositivos.forEach(dispositivo -> this.crearRestricciones(dispositivo));
		
	}

	private LinearConstraint crearRestricciones(DispositivoInteligente dispositivo) {
		LinearConstraint restriccionMayorA = new LinearConstraint(dispositivo.getConsumoIdeal(), Relationship.GEQ, dispositivo.getConsumoMinimo());
		LinearConstraint restriccionMenosA = new LinearConstraint(dispositivo.getConsumoIdeal(), Relationship.LEQ, dispositivo.getConsumoMaximo());
	}

	public void getVariables(ArrayList<DispositivoInteligente> dispositivos) {
		// TODO Auto-generated method stub
		
	}

}
