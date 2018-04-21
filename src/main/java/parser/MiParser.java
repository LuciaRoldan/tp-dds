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

///////////////////// PARSEAR OBJETO ///////////////////////////

//TODO Hacer singleton
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiParser {

    JSONParser parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();


    public Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {



        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Dispositivo dispo = mapper.readValue(new File(nombreArchivo), Dispositivo.class);

        return  dispo;
    }

    public List<Usuario> parsearUsuario(String nombreArchivo) throws IOException {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Usuario usuario = mapper.readValue(new File(nombreArchivo), Usuario.class);
        List<Usuario> listaDeUsuarios = mapper.readValue(new File(nombreArchivo),new TypeReference<List<Usuario>>(){});
        return listaDeUsuarios;
    }

    /*
    public Usuario tipoDeUsuario(String nombreArchivo) throws IOException {

        List<Usuario> listaClases = asList(new Administrador(),new Cliente());


        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode node = new ObjectMapper().readValue(nombreArchivo, ObjectNode.class);
       // JsonNode idNode = rootNode.path("id");
      //  System.out.println("id: "+ idNode.asText());
        JsonNode nodo = node .path("tipoDeUsuario");

        TipoDeUsuario tduEnum = TipoDeUsuario.valueOf(nodo.asText());

        Usuario tipoDeUsuario =  listaClases.stream()
                .filter(x -> tduEnum.equals(x.getTipoDeUsuario()))
                .findAny()
                .orElse(null);


        return tipoDeUsuario;
    }
    */

    public Administrador parsearAdministrador(String nombreArchivo) throws IOException{

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Administrador administrador = mapper.readValue(new File(nombreArchivo), Administrador.class);
        return administrador;
    }

}

// mvn exec:java -Dexec.mainClass="Parser" -X
/* {
   "nombresYapellidos": "MatiasMorsa",
   "tipoDocumento": "DNI",
   "nombreDeUsuario": "Matias21313",
   "domicilio": "Av.del libertador 2000",
   "telefono": 44444444,
   "documento": 1234456,
   "Contrasena": "123321",
   //"categoriaResidencial": "CategoriaR8",
   "FechaDeAlta": "01012001",
   "dispositivos":{
      "nombre": "juanperez",
      "kWh": 12,
      "encendido": true,
      "tipoDeDispositivo": null
   }
}
*/