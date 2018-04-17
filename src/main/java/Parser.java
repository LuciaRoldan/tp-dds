import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    ///////////////////// PARSEAR OBJETO ///////////////////////////

    public Dispositivo parsearDispositivo(String nombreArchivo) throws IOException {

        File archivo = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo);


        JSONArray a = (JSONArray) parser.parse(new FileReader(archivo));

        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;

            String name = (String) person.get("name");
            System.out.println(name);

            String city = (String) person.get("city");
            System.out.println(city);

            String job = (String) person.get("job");
            System.out.println(job);

            JSONArray cars = (JSONArray) person.get("cars");

            for (Object c : cars)
            {
                System.out.println(c+"");
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        //JSON from file to Object
        Dispositivo dispositivo = mapper.readValue(archivo, Dispositivo.class);

        return dispositivo;


    }

    public Cliente parsearCliente(String nombreArchivo) throws IOException {

            File archivo = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo);

            ObjectMapper mapper = new ObjectMapper();

            //JSON from file to Object
            Cliente cliente = mapper.readValue(archivo, Cliente.class);

            return cliente;
    }

}

