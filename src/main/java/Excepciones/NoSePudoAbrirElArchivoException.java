package Excepciones;

public class NoSePudoAbrirElArchivoException extends RuntimeException {
	public NoSePudoAbrirElArchivoException() {
		System.out.println("No se pudo abrir el archivo");
	}
}
