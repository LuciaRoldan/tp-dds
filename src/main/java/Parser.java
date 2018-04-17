import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

///////////////////// PARSEAR OBJETO ///////////////////////////

    public class Parser {

        public static void main(String[] args) throws IOException {

            System.out.println("TESTTTTTT");
            parsearDispositivo("src/main/java/hola.json");
            System.out.println("TESTTTTTT");


        }

        public static void parsearDispositivo(String nombreArchivo) {

             JSONParser parser = new JSONParser();

            try {

                //Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo));

                Object obj = parser.parse(new FileReader("src/main/java/hola.json"));

                /*String nombre;
	            int kWh;
                boolean encendido;
                TipoDeDispositivo tipoDeDispositivo;
                */

                JSONObject jsonObject = (JSONObject) obj;
                System.out.println(jsonObject);

                String name = (String) jsonObject.get("nombre");
                System.out.println(name);

                long kWH = (long) jsonObject.get("kWh");
                System.out.println(kWH);

                TipoDeDispositivo tdd = (TipoDeDispositivo) jsonObject.get("TipoDeDispositivo") ;

                /*
                // loop array
                JSONArray msg = (JSONArray) jsonObject.get("encendido");
                Iterator<String> iterator = msg.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                */

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }




/*
    public Cliente parsearCliente(String nombreArchivo) throws IOException {

            File archivo = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo);

            ObjectMapper mapper = new ObjectMapper();

            //JSON from file to Object
            Cliente cliente = mapper.readValue(archivo, Cliente.class);

            return cliente;
    }
    */

}

