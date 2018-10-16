package usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import dispositivosConcretos.DispositivoConcreto;

public class RestriccionBuilder {
	
	private static int i;
	private static int posicion;
	double maximoConsumo;
	
	public static ArrayList<LinearConstraint> getRestricciones(List<DispositivoConcreto> dispositivos, double maximoConsumo){
		
		ArrayList<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		
		ArrayList<LinearConstraint> restriccionesHoras = crearRestriccionHoras(dispositivos);
		LinearConstraint restriccionPrincipal = crearRestriccionPrincipal(dispositivos, maximoConsumo);
		
		restricciones.addAll(restriccionesHoras);
		restricciones.add(restriccionPrincipal);
		
		return restricciones;
	}
	
	private static LinearConstraint crearRestriccionPrincipal(List<DispositivoConcreto> dispositivos, double maximoConsumo){

		i = 0;
		double coeficientes[] = new double[dispositivos.size()];	
		
		dispositivos.forEach(dispositivo -> {
							coeficientes[i]=dispositivo.getPotencia();
							i++;
							});
		
		LinearConstraint restriccionPrincipal = new LinearConstraint(coeficientes, Relationship.LEQ, maximoConsumo);

		return restriccionPrincipal;
	}

	private static ArrayList<LinearConstraint> crearRestriccionHoras(List<DispositivoConcreto> dispositivos) {
		
		posicion = 0;
		ArrayList<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		
		dispositivos.forEach(dispositivo -> {
			LinearConstraint restriccionMayorA = new LinearConstraint(prepararArray(dispositivo, posicion, dispositivos), Relationship.GEQ, dispositivo.getUsoMensualMinimo());
			LinearConstraint restriccionMenorA = new LinearConstraint(prepararArray(dispositivo, posicion, dispositivos), Relationship.LEQ, dispositivo.getUsoMensualMaximo());
			restricciones.add(restriccionMenorA);
			restricciones.add(restriccionMayorA);
			posicion++;
		});
		
		return restricciones;
	}
	

	private static double[] prepararArray(DispositivoConcreto dispositivo, int posicion, List<DispositivoConcreto> dispositivos) {
		double array[] = new double[dispositivos.size()];
		array[posicion] = 1;
		return array;
	}
	
}