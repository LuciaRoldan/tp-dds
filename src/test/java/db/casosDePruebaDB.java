package db;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import exceptionParser.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import repositorio.RepositorioDeUsuarios;
import repositorio.RepositorioDeTransformadoresYZonas;
import transformador.Transformador;
import usuario.Cliente;
import usuario.TipoDocumento;
import usuario.Usuario;

public class casosDePruebaDB {
	ClaseParaDB claseParaDB = new ClaseParaDB();
	

	@Test
	public void caso1() {
		//Crear 1 usuario nuevo. Persistirlo. Recuperarlo, modificar la geolocalización y grabarlo. Recuperarlo y evaluar 
		//que el cambio se haya realizado.

		Cliente cliente = ClaseParaDB.getCliente();
		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
		repositorioDeUsuarios.agregarUsuario(cliente);
		
		Cliente cliente2 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(cliente.getNombreUsuario());
		Float nuevaCoordenadaX = new Float(100);
		cliente2.setCoordenadaX(nuevaCoordenadaX);
		
		Cliente cliente3 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(cliente.getNombreUsuario());
		assertEquals(nuevaCoordenadaX, cliente3.getCoordenadaX());
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
	public void caso4() throws NoSePudoAbrirElArchivoException, IOException {
		//Recuperar todos los transformadores persistidos. Registrar la cantidad. Agregar una instancia de Transformador al JSON de 
		//entradas. Ejecutar el método de lectura y persistencia. Evaluar que la cantidad actual sea la anterior + 1.
		
		Transformador transformador = ClaseParaDB.getTransformador();
		RepositorioDeTransformadoresYZonas repoTransformadores = new RepositorioDeTransformadoresYZonas();
		repoTransformadores.persistirTransformador(transformador);
		
		List<Transformador> transformadores = repoTransformadores.getListaTransformadores();
		int cantidadOriginal = transformadores.size();
		
		ParserTransformadorYZona parser = new ParserTransformadorYZona();
		Transformador nuevoTransformador = parser.parsearTransformador("src/test/java/db/transformador.json");
		repoTransformadores.persistirTransformador(nuevoTransformador);
		
		transformadores = repoTransformadores.getListaTransformadores();
		assertEquals(cantidadOriginal +1, transformadores.size());
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
