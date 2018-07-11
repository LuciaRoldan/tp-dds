package parserTransformadorYZona;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import java.io.File;
import transformador.Transformador;
import zona.Zona;
import java.io.IOException;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;


public class ParserTransformadorYZona {

	JSONParser parser = new JSONParser();
	ObjectMapper mapper = new ObjectMapper();

//	public Transformador parsearTransformador(String archivo) throws NoSePudoAbrirElArchivoException{
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	 public ParserTransformadorYZona(){
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    }
	 public Transformador parsearTransformador(String archivo) throws NoSePudoAbrirElArchivoException, IOException {
		try {
			Transformador transformador = mapper.readValue(new File(archivo), Transformador.class);
			return transformador;
		
		} catch (IOException excepcion) {
			//throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+ archivo);
			throw excepcion;
		}
	}
	
	public Zona parsearZona(String archivo) throws NoSePudoAbrirElArchivoException{
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			Zona zona = mapper.readValue(new File(archivo), Zona.class);
			return zona;
		
		} catch (IOException excepcion) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+ archivo);
		}
	}
	
	
}

