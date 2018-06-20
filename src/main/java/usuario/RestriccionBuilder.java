package usuario;

import java.util.ArrayList;

import org.apache.commons.math3.optim.linear.LinearConstraint;

import dispositivo.DispositivoInteligente;

public class RestriccionBuilder {
	
	ArrayList<DispositivoInteligente> dispositivos;
	ArrayList<LinearConstraint> restricciones;
	ArrayList<Double> variables;
	
	public RestriccionBuilder(ArrayList<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void getRestricciones(ArrayList<DispositivoInteligente> dispositivos) {
		dispositivos.forEach(dispositivo -> this.crearRestriccion(dispositivo));
		
	}

	private LinearConstraint crearRestriccion(DispositivoInteligente dispositivo) {
		LinearConstraint restriccion = new LinearConstraint(dispositivo.getConsumoIdeal(), )
	}

	public void getVariables(ArrayList<DispositivoInteligente> dispositivos) {
		// TODO Auto-generated method stub
		
	}

}
