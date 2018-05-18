package sensores;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;
import reglas.Regla;


public abstract class Sensor {

	List<Regla> reglas = new ArrayList<Regla>();
	
	public void agregarRegla(Regla unaRegla){
	      reglas.add(unaRegla);
	   }
	
//	 public void pasoAlgo(){
//		 reglas.forEach(regla -> regla.pasoAlgo());
//	 }

	
	
}
