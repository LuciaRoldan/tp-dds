package parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/////////////////////////////////////// PARSER CREADO PARA USAR EN CASO DE EMERGENCIA ////////////////////////////////

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtroParserMasGenerico {

    JSONParser   parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();

    public OtroParserMasGenerico(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> List<T> parsear(Class<T> clase,String nombreArchivo) throws IOException {
//		https://github.com/FasterXML/jackson-core/issues/295
        List<T> listaObjetos = mapper.readValue(new File(nombreArchivo),mapper.getTypeFactory().constructCollectionLikeType(ArrayList.class, clase));
        return listaObjetos;
    }

}
