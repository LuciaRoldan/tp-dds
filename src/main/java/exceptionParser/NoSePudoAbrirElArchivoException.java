package exceptionParser;

import javax.swing.text.html.parser.Parser;

public class NoSePudoAbrirElArchivoException extends ParserExcepcion {

	public NoSePudoAbrirElArchivoException(String mensaje) {
        super(mensaje);
    }
}
