package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Excepciones.NoSePudoAbrirElArchivoException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtroParserMasGenerico {

    JSONParser   parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();

    public OtroParserMasGenerico(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

	public <T> List<T> parsear(Class<T> clase, String nombreArchivo) {
		// https://github.com/FasterXML/jackson-core/issues/295
		try {
			List<T> listaObjetos = mapper.readValue(new File(nombreArchivo),
					mapper.getTypeFactory()
					.constructCollectionLikeType(ArrayList.class, clase));
			return listaObjetos;
		} catch (IOException e) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+nombreArchivo);
		}
	}

}
