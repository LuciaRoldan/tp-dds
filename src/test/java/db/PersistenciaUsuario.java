package db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import repositorio.RepositorioDeUsuarios;
import usuario.Cliente;

public class PersistenciaUsuario {
	
	@Test
	public void persisteClienteYLoRecupera() {

		Cliente cliente = ClaseParaDB.getCliente();
		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
		repositorioDeUsuarios.agregarUsuario(cliente);
		
		
		Cliente cliente2 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(cliente.getNombreUsuario());
		
		assertEquals(cliente, cliente2);
	}

}
