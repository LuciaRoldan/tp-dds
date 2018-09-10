package db;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import exceptionParser.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import repositorio.RepositorioDeTransformadores;
import repositorio.RepositorioDeUsuarios;
import transformador.Transformador;
import usuario.Cliente;
import usuario.TipoDocumento;
import usuario.Usuario;

public class casosDePruebaDB {
	ClaseParaDB claseParaDB = new ClaseParaDB();
	

	@Test
	public void caso1() {
		
		ClaseParaDB dbMock = new ClaseParaDB();
		
		Cliente cliente=  new Cliente("Maximo Cozzetti", "Calle falsa 123", "01/01/2001", "Emilio Ravenna",
	                				  "caracterizacion", TipoDocumento.DNI ,  007, 4545-4545,
	                				  CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
		repositorioDeUsuarios.agregarUsuario(cliente);
		dbMock.persistirCliente(cliente);
		
		Usuario clienteRecuperado = claseParaDB.obtenerUsuarioPorNombre("Emilio Ravenna");
		assertEquals(clienteRecuperado, cliente);

		dbMock.modificarGeo(clienteRecuperado, 2, 3);
		
		assertEquals(new Float(2), clienteRecuperado.getCoordenadaX());
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
		RepositorioDeTransformadores repoTransformadores = new RepositorioDeTransformadores();
		repoTransformadores.persistirTransformador(transformador);
		
		List<Transformador> transformadores = repoTransformadores.getListaTransformadores();
		int cantidadOriginal = transformadores.size();
		
		ParserTransformadorYZona parser = new ParserTransformadorYZona();
		Transformador nuevoTransformador = parser.parsearTransformador("src/test/java/db/transformador.json");
		repoTransformadores.persistirTransformador(nuevoTransformador);
		
		transformadores = repoTransformadores.getListaTransformadores();
		//cantidadOriginal +1, transformadores.size()
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
