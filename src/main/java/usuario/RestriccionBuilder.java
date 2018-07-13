package usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import dispositivosConcretos.DispositivoConcreto;

public class RestriccionBuilder {
	
	ArrayList<DispositivoConcreto> dispositivos;
	ArrayList<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
	double maximoConsumo;
	int posicion;
	
	public RestriccionBuilder(ArrayList<DispositivoConcreto> dispositivos, double maximoConsumo) {
		this.dispositivos = dispositivos;
		this.maximoConsumo = maximoConsumo;
		this.posicion = 0;
	}
	
	public ArrayList<LinearConstraint> getRestricciones(){
		this.crearRestriccionHoras();
		this.crearRestriccionPrincipal();
		return restricciones;
	}
	
	private void crearRestriccionPrincipal() {
		double coeficientes[] = new double[dispositivos.size()];
		int i=0;
		for (DispositivoConcreto dispositivo : dispositivos) {
			coeficientes[i]=dispositivo.getPotencia();
			i++;			
		}
		restricciones.add(new LinearConstraint(coeficientes, Relationship.LEQ, maximoConsumo));
	}

	public void crearRestriccionHoras() {
		
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
