package Excepciones;


public class NoSePudoAbrirElArchivoException extends RuntimeException {
	public NoSePudoAbrirElArchivoException(String mensaje) {
        super(mensaje);
    }
}
