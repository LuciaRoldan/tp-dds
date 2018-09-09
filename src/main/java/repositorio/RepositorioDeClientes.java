package repositorio;

public class RepositorioDeClientes extends Repositorio {

	public static RepositorioDeClientes getInstancia() {
		
		RepositorioDeClientes instancia = new RepositorioDeClientes();
		
		return instancia;
	}
}
