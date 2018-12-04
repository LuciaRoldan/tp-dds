//package db;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import dispositivosConcretos.DispositivoConcreto;
//import repositorio.RepositorioDeDispositivos;
//import repositorio.RepositorioDeUsuarios;
//import usuario.Cliente;
//
//public class PersistenciaDeDispositivos {
//	
//	ClaseParaDB claseParaDB = new ClaseParaDB();
//	Cliente cliente = claseParaDB.getClienteConDispositivos();
//
//	@Test
//	public void recuperarDispositivoPorIdUsuario() {
//		RepositorioDeDispositivos repo = new RepositorioDeDispositivos();
//		RepositorioDeUsuarios repo2 = new RepositorioDeUsuarios();
//		repo2.agregarUsuario(cliente);
//		
//		DispositivoConcreto dispositivoOriginal = cliente.getPrimerDispositivo();
//		
//		DispositivoConcreto dispositivo = repo.getDispositivoPorUsuario(cliente.getId());
//		
//		assertEquals(dispositivo.getId(), dispositivoOriginal.getId());
//	}
//	
//	@Test
//	public void recuperarDispositivoPorUsername() {
//		RepositorioDeDispositivos repo = new RepositorioDeDispositivos();
//		RepositorioDeUsuarios repo2 = new RepositorioDeUsuarios();
//		repo2.agregarUsuario(cliente);
//		
//		DispositivoConcreto dispositivoOriginal = cliente.getPrimerDispositivo();
//		
//		DispositivoConcreto dispositivo = repo.getDispositivoPorUsername(cliente.getNombreUsuario());
//		
//		assertEquals(dispositivo.getId(), dispositivoOriginal.getId());
//	}
//
//}
