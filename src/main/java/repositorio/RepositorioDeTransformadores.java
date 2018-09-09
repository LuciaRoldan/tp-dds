package repositorio;

import java.util.ArrayList;
import java.util.List;

import transformador.Transformador;

public class RepositorioDeTransformadores extends Repositorio{
	//private List<Transformador> listaDeTransformadores = new ArrayList<Transformador>();
	
	public void persistirTransformador(Transformador transformador){
        this.persistir(transformador);
    }
	
	public Transformador getTransformador(Integer id) {
        return entityManager.find(Transformador.class,id );
    }
	
	public List<Transformador> getListaTransformadores(){
		List<Transformador> lista = new ArrayList<Transformador>();
		lista = entityManager.createQuery("SELECT t FROM Transformador t WHERE t.numeroDeTransformador > 0").getResultList();
		return lista;
	}

}
