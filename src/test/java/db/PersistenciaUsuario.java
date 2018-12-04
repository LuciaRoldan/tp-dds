//package db;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.junit.Test;
//
//import categoria.CategoriaResidencial;
//import repositorio.RepositorioDeUsuarios;
//import sensor.Sensor;
//import usuario.Cliente;
//import usuario.TipoDocumento;
//
//public class PersistenciaUsuario {
//	
//	@Test
//	public void persisteClienteYLoRecuperaPorUsername() {
//
//		Cliente rorro = new Cliente("Ro Chipian", "Libertador 1300", LocalDate.of(2001, 01, 01), "RoChipian2",
//                "lol12345", TipoDocumento.DNI , 40123456, 4545-4545,
//        CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
//		
//		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
//		repositorioDeUsuarios.agregarUsuario(rorro);
//		
//		Cliente cliente2 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(rorro.getNombreUsuario());
//		
//		assertEquals(rorro.getId(), cliente2.getId());
//	}
//	
//	@Test
//	public void persisteClienteYLoRecuperaPorId() {
//
//		Cliente rorro = new Cliente("Ro Chipian", "Libertador 1300", LocalDate.of(2001, 01, 01), "RoChipian",
//                "lol12345", TipoDocumento.DNI , 40123456, 4545-4545,
//        CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
//		
//		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
//		repositorioDeUsuarios.agregarUsuario(rorro);
//		
//		Cliente cliente2 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorId(rorro.getId());
//		
//		assertEquals(rorro.getId(), cliente2.getId());
//	}
//	
//	@Test
//	public void recuperarSensorDeCliente() {
//		Cliente rorro = new Cliente("Ro Chipian", "Libertador 1300", LocalDate.of(2001, 01, 01), "RoChipian",
//                "lol12345", TipoDocumento.DNI , 40123456, 4545-4545,
//        CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
//		
//		Sensor sensorTemperatura = new Sensor();
//		sensorTemperatura.cambiarMedicion(100);
//		rorro.agregarSensor(sensorTemperatura);
//		
//		RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();
//		repositorioDeUsuarios.agregarUsuario(rorro);
//		
//		List<Sensor> sensores = repositorioDeUsuarios.obtenerSensoresDeUsuario(rorro.getId());
//		Sensor sensor2 = sensores.get(0);
//		
//		assertEquals(sensorTemperatura.getId(), sensor2.getId());
//	}
//
//}
