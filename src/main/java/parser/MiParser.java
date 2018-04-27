package parser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dispositivos.Dispositivo;
import org.json.simple.parser.JSONParser;
import usuario.Administrador;
import usuario.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.List;

//TODO Hacer singleton
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiParser {

    JSONParser   parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();

    public List<Usuario> parsearUsuario(String nombreArchivo) throws IOException {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Usuario> listaDeUsuarios = mapper.readValue(new File(nombreArchivo),new TypeReference<List<Usuario>>(){});
        return listaDeUsuarios;
    }

    /////////////////////////// FUNCIONES VIEJAS DE PRUEBA ////////////////////////

    public Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Dispositivo dispo = mapper.readValue(new File(nombreArchivo)      ,  Dispositivo.class);

        return  dispo;
    }

    public Administrador parsearAdministrador(String nombreArchivo) throws IOException{

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Administrador administrador = mapper.readValue(new File(nombreArchivo), Administrador.class);
        return administrador;
    }

}
