package sensores;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;


public abstract class Sensor {
	List<Regla> reglas = new ArrayList<>();
	
	public void agregarRegla(Regla unaRegla){
	      reglas.add(unaRegla);
	   }
	
//	 public void pasoAlgo(){
//		 reglas.forEach(regla -> regla.pasoAlgo());
//	 }

	
	
}
