import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dispositivos.Dispositivo;
import org.json.simple.parser.JSONParser;
import usuario.Administrador;
import usuario.Cliente;

import java.io.File;
import java.io.IOException;

///////////////////// PARSEAR OBJETO ///////////////////////////

//TODO Hacer singleton

public class Parser {


    public Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {

        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        Dispositivo dispo = mapper.readValue(new File(nombreArchivo), Dispositivo.class);
        return  dispo;
    }


    public Cliente parsearCliente(String nombreArchivo) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Cliente cliente = mapper.readValue(new File(nombreArchivo), Cliente.class);
        return cliente;
    }


    public Administrador parsearAdministrador(String nombreArchivo) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
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