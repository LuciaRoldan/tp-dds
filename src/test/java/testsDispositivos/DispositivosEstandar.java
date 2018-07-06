package testsDispositivos;

import static org.junit.Assert.assertEquals;

import dispositivo.DispositivoEstandar;
import org.junit.Test;

public class DispositivosEstandar {

	DispositivoEstandar dispositivoEstandar = ClasesParaTestearDispositivos.unDispositivoEstandar();
	
	@Test
	public void testConsumoMensual() {
		assertEquals(60000, dispositivoEstandar.consumoMensual(),0.05);
	}
	
}
