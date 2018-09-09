package db;

import static org.junit.Assert.*;

import org.junit.Test;

public class casosDePruebaDB {

	@Test
	public void caso1() {
		//Crear 1 usuario nuevo. Persistirlo. Recuperarlo, modificar la geolocalización y grabarlo. Recuperarlo y evaluar 
		//que el cambio se haya realizado.
		assertTrue(true);
	}
	
	@Test
	public void caso2() {
		//Recuperar un dispositivo. Mostrar por consola todos los intervalos que estuvo encendido durante el último mes. Modificar 
		//su nombre (o cualquier otro atributo editable) y grabarlo. Recuperarlo y evaluar que el nombre coincida con el esperado.
		assertTrue(true);
	}
	
	@Test
	public void caso3() {
		//Crear una nueva regla. Asociarla a un dispositivo. Agregar condiciones y acciones. Persistirla. Recuperarla y ejecutarla. 
		//Modificar alguna condición y persistirla. Recuperarla y evaluar que la condición modificada posea la última modificación.
		assertTrue(true);
	}
	
	@Test
	public void caso4() {
		//Recuperar todos los transformadores persistidos. Registrar la cantidad. Agregar una instancia de Transformador al JSON de 
		//entradas. Ejecutar el método de lectura y persistencia. Evaluar que la cantidad actual sea la anterior + 1.
		assertTrue(true);
	}
	
	@Test
	public void caso5() {
		// Dado un hogar y un período, mostrar por consola (interfaz de comandos) el consumo total. Dado un dispositivo y un período, 
		//mostrar por consola su consumo promedio. Dado un transformador y un período, mostrar su consumo promedio. Recuperar un 
		//dispositivo asociado a un hogar de ese transformador e incrementar un 1000 % el consumo para ese período. Persistir el 
		//dispositivo. Nuevamente mostrar el consumo para ese transformador.
		assertTrue(true);
	}

}
