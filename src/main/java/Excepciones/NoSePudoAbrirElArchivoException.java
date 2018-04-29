package Excepciones;

public class NoSePudoAbrirElArchivoException extends Exception {
	public NoSePudoAbrirElArchivoException() {
		System.out.println("No se pudo abrir el archivo");
	}
}
