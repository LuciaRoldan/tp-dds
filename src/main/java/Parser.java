import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Parser {
    ///////////////////// PARSEAR OBJETO ///////////////////////////

    public Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {

        File archivo = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{'name' : 'mkyong'}";

        //JSON from file to Object
        Dispositivo dispositivo = mapper.readValue(archivo, Dispositivo.class);

        return dispositivo;


    }

    public Cliente parsearCliente(String nombreArchivo) throws IOException {

            File archivo = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo);

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = "{'name' : 'mkyong'}";

            //JSON from file to Object
            Cliente cliente = mapper.readValue(archivo, Cliente.class);

            return cliente;
    }

}