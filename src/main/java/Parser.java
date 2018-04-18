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
    //private Parser instance = null;
    //public Parser getInstance() { }
    public static void main(String[] args) throws IOException {
        //System.out.println("TESTTTTTT");
        //parsearDispositivo("src/main/java/hola.json");
        System.out.println("TESTTTTTT");
        parsearCliente("src/main/java/hola.json");
    }

    public static Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        //JSON from file to Object
        Dispositivo dispo = mapper.readValue(new File(nombreArchivo), Dispositivo.class);
        return  dispo;
    }


    public static Cliente parsearCliente(String nombreArchivo) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Cliente cliente = mapper.readValue(new File(nombreArchivo), Cliente.class);
        System.out.print(cliente.getCategoriaResidencial());
        return cliente;
    }


    public static Administrador parsearAdministrador(String nombreArchivo) throws IOException{
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //JSON from file to Object
        Administrador admin = mapper.readValue(new File(nombreArchivo), Administrador.class);
        System.out.print(admin);
        return admin;
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