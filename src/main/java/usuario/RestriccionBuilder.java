package usuario;

import java.util.ArrayList;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivosConcretos.DispositivoConcreto;

public class RestriccionBuilder {
	
	ArrayList<DispositivoConcreto> dispositivos;
	ArrayList<LinearConstraint> restricciones;
	ArrayList<Double> variables;
	int posicion;
	
	public RestriccionBuilder(ArrayList<DispositivoConcreto> dispositivos) {
		this.dispositivos = dispositivos;
		this.posicion = 0;
	}
	
	public ArrayList<LinearConstraint> getRestricciones(){
		this.crearRestricciones();
		return restricciones;
	}

	public void crearRestricciones() {
		dispositivos.forEach(dispositivo -> {
			LinearConstraint restriccionMayorA = new LinearConstraint(prepararArray(dispositivo, posicion), Relationship.GEQ, dispositivo.getUsoMensualMinimo());
			LinearConstraint restriccionMenorA = new LinearConstraint(prepararArray(dispositivo, posicion), Relationship.LEQ, dispositivo.getUsoMensualMaximo());
			restricciones.add(restriccionMenorA);
			restricciones.add(restriccionMayorA);
			posicion +=1;
		});
	}
	
	private double[] prepararArray(DispositivoConcreto dispositivo, int posicion) {
		double array[] = new double[dispositivos.size()];
		array[posicion] = 1;
		return array;
	}
	

}
