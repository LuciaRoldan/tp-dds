package repositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoFactory;
import dispositivo.estados.Encendido;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import mock.ApagadoMock;
import mock.EncendidoMock;
import usuario.Administrador;
import usuario.Cliente;
import usuario.TipoDocumento;

public class MockDB {
	
	public void inicializarDB() {
		RepositorioDeUsuarios repo = new RepositorioDeUsuarios();
		
		/////////////// Persisto un cliente con un dispositivo con estados //////////////////////////////
		
		Cliente cliente = new Cliente("Maximo Cozzetti", "Calle falsa 123", LocalDate.of(2001, 01, 01), "Emilio Ravenna", "caracterizacion", TipoDocumento.DNI ,  007, 4545-4545, CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("aire");
		AireAcondicionado aire = factory.crearAireAcondicionado(2200);
        EncendidoMock encendido1 = new EncendidoMock(LocalDateTime.now().minus(25, ChronoUnit.DAYS), LocalDateTime.now().minus(20, ChronoUnit.DAYS));
        ApagadoMock apagado1 = new ApagadoMock(LocalDateTime.now().minus(20, ChronoUnit.DAYS), LocalDateTime.now().minus(15, ChronoUnit.DAYS));
        EncendidoMock encendido2 = new EncendidoMock(LocalDateTime.now().minus(15, ChronoUnit.DAYS), LocalDateTime.now().minus(10, ChronoUnit.DAYS));
        ApagadoMock apagado2 = new ApagadoMock(LocalDateTime.now().minus(10, ChronoUnit.DAYS), LocalDateTime.now().minus(5, ChronoUnit.DAYS));
		Encendido encendido3 = new Encendido();

		aire.agregarEstado(encendido1);
		aire.agregarEstado(apagado1);
		aire.agregarEstado(encendido2);
		aire.agregarEstado(apagado2);
		aire.agregarEstado(encendido3);
		
		List<DispositivoConcreto> disp = new ArrayList<DispositivoConcreto>();
	    disp.add(aire);
	    cliente.setDispositivos((ArrayList<DispositivoConcreto>) disp);
		
	    repo.agregarUsuario(cliente);
	    
		//////////////// Persisto un administrador ///////////////////////////////
	    
	    Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123", LocalDate.now().minusMonths(1), "jperez", "123", (float) 0 ,(float) 0);
	    repo.agregarUsuario(administrador);
	
	}
}
