package br.com.db1.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import br.com.db1.start.classe.Pessoa;
import br.com.db1.start.tipo.TipoDocumento;

public class MainTestPessoa {

	@Test
	public void metodoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Juliano");
		pessoa.setTipoDocumento(TipoDocumento.CPF);
		pessoa.setDocumento("00000000000");
			
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();

		factory.close();
	}
	
	@Test
	public void deleteTest() {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Pessoa pessoa = manager.find(Pessoa.class, 3L);
		manager.getTransaction().begin();
		manager.remove(pessoa);
		manager.getTransaction().commit();

		factory.close();*/
	}

	@Test
	public void updateTest() {
	/*	EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Pessoa pessoa = manager.find(Pessoa.class, 2L);
		pessoa.setNome("Juliano");
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();

		factory.close();*/

	}

	@Test
	public void selectHqlTest() {
	/*	EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("Select p from Pessoa p");
		List<Pessoa> pessoas = query.getResultList(); 

		factory.close();*/

	}

	@Test
	public void selectSqlNativoTest() {
	/*	EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNativeQuery("Select * from pessoa p");
		List<Pessoa> pessoas = query.getResultList();

		factory.close();*/

	}

}
