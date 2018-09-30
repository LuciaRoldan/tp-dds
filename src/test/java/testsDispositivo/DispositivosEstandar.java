package testsDispositivo;

import static org.junit.Assert.assertEquals;

import dispositivo.DispositivoEstandar;
import org.junit.Test;

public class DispositivosEstandar {

	DispositivoEstandar dispositivoEstandar = new ClasesParaTestearDispositivos().unDispositivoEstandar();
	
	@Test
	public void testConsumoMensual() {
		assertEquals(40, dispositivoEstandar.consumoMensual(),0.05);
	} //El consumo mensual da cero porque el dispositivoEstandar no puede calcular su consumo
	
}
