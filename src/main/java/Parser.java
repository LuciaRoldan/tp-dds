import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Dispositivos.Dispositivo;
import Dispositivos.TipoDeDispositivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

///////////////////// PARSEAR OBJETO ///////////////////////////

    public class Parser {

        public static void main(String[] args) throws IOException {

            //System.out.println("TESTTTTTT");
            //parsearDispositivo("src/main/java/hola.json");
            System.out.println("TESTTTTTT");
            parsearCliente("src/main/java/hola.json");


        }

        public static Dispositivo parsearDispositivo(String nombreArchivo) {

             JSONParser parser = new JSONParser();

             Dispositivo dispo = new Dispositivo();

            try {

                //Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator") + nombreArchivo));

                Object obj = parser.parse(new FileReader(nombreArchivo));

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

                boolean encendido = (boolean) jsonObject.get("encendido");
                System.out.print(encendido);

                TipoDeDispositivo tdd = (TipoDeDispositivo) jsonObject.get("TipoDeDispositivo") ;
                System.out.print(tdd);


               dispo.inicializarDispositivo(name,kWH,encendido,tdd);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return  dispo;

        }





    public static Cliente parsearCliente(String nombreArchivo) throws IOException {

        JSONParser parser = new JSONParser();
        Cliente cliente = new Cliente();

        try {


            Object obj = parser.parse(new FileReader(nombreArchivo));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String nombresYapellidos = (String) jsonObject.get("nombresYapellidos");
            System.out.println(nombresYapellidos);

            TipoDocumento tipoDocument = (TipoDocumento) jsonObject.get("tipoDocumento");
            System.out.println(tipoDocument);

            String nombreUsuario = (String) jsonObject.get("nombreDeUsuario");
            System.out.println(nombreUsuario);

            String domicilio = (String) jsonObject.get("domicilio");
            System.out.println(domicilio);

            long telefono = (long) jsonObject.get("telefono");
            System.out.println(telefono);
            long numeroDocumento = (long) jsonObject.get("numeroDocumento");
            System.out.println(numeroDocumento);



            String fechaDeAlta = (String) jsonObject.get("FechaDeAlta");
            System.out.println(fechaDeAlta);



            String categoriaResidencial = (String) jsonObject.get("TipoDeCategoria");
            System.out.println(categoriaResidencial);

            String contrasena = (String) jsonObject.get("Contrasena");
            System.out.println(contrasena);




            JSONObject dispositivos = (JSONObject) jsonObject.get("Dispositivos");
            System.out.println(dispositivos);

            /*
            Iterator<Dispositivo> iterator = dispositivos.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            */


            //public void inicilalizarCliente(String g nombreUsuario, String contrasena, String tipoDocumento,long numeroDocumento, String telefono, categoriaResidencial categoriaResidencial, ArrayList<Dispositivo> dispositivos){

                cliente.inicializarCliente(nombresYapellidos,domicilio,null,nombreUsuario,contrasena,tipoDocument,numeroDocumento,telefono,null,null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return cliente;

    }
    }




