package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parser {

    JSONParser   parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();

    public Parser(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> List<T> parsear(Class<T> clase,String nombreArchivo) throws IOException {
//		https://github.com/FasterXML/jackson-core/issues/295
        List<T> listaObjetos = mapper.readValue(new File(nombreArchivo),mapper.getTypeFactory().constructCollectionLikeType(ArrayList.class, clase));
        return listaObjetos;
    }

}
