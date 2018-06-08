package testsDispositivos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import dispositivo.Dispositivo;

public class DispositivosEstandar {

	Dispositivo dispositivoEstandar = ClasesParaTestearDispositivos.unDispositivoEstandar();
	
	@Test
	public void testConsumoMensual() {
		assertEquals(Long.valueOf(600000), dispositivoEstandar.consumoMensual());
	}
	
}
