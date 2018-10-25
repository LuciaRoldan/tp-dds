package server;

import java.time.LocalDate;
import java.util.ArrayList;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import categoria.CategoriaResidencial;
import usuario.Cliente;
import dispositivosConcretos.*;
import repositorio.RepositorioDeUsuarios;
import testsCliente.ClasesParaTestearCliente;
import usuario.TipoDocumento;

public class Init implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
	
	public static void main(String[] args) {
		new Init().init();
	}
	
	public void init(){
		withTransaction(() ->{
			
			RepositorioDeUsuarios repo = RepositorioDeUsuarios.getInstancia();
			
			//Cliente rorro = new Cliente("Ro Chi", "Gurru", LocalDate.of(1997, 11, 14), "rokpa", "donas",
			//							TipoDocumento.DNI, 40404040, 1555555555, CategoriaResidencial.CATEGORIAR1,
			//							new ArrayList<DispositivoConcreto>(), (float) 10, (float) 10 );
			//repo.agregarUsuario(rorro);
			Cliente jperez = ClasesParaTestearCliente.clienteEstandar();
			repo.agregarUsuario(jperez);
		});
	}
}
