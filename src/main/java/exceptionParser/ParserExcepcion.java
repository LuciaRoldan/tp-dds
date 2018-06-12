package exceptionParser;

import dispositivo.DispositivoInteligente;

import javax.swing.text.html.parser.Parser;
import java.util.Date;

public class ParserExcepcion extends RuntimeException {
    Date date;
    String error;

    public ParserExcepcion(String mensaje){
        error = mensaje;
        date = new Date();
    }
}
