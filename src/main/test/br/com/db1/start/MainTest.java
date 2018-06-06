package br.com.db1.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import br.com.db1.start.classe.Cidade;
import br.com.db1.start.tipo.Uf;


public class MainTest {

	@Test
	public void metodoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Cidade cidade = new Cidade();
		cidade.setNome("Curitiba");
		cidade.setUf(Uf.PR);
		manager.getTransaction().begin();
		manager.persist(cidade);
		manager.getTransaction().commit();

		factory.close();
	}
	
	@Test
	public void deleteTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Cidade cidade = manager.find(Cidade.class, 3L);
		manager.getTransaction().begin();
		manager.remove(cidade);
		manager.getTransaction().commit();

		factory.close();
	}

	@Test
	public void updateTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Cidade cidade = manager.find(Cidade.class, 2L);
		cidade.setNome("Maringa");
		manager.getTransaction().begin();
		manager.persist(cidade);
		manager.getTransaction().commit();

		factory.close();

	}

	@Test
	public void selectHqlTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("Select c from Cidade c");
		List<Cidade> cidades = query.getResultList();

		factory.close();

	}

	@Test
	public void selectSqlNativoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNativeQuery("Select * from cidade c");
		List<Cidade> cidades = query.getResultList();

		factory.close();

	}

}
