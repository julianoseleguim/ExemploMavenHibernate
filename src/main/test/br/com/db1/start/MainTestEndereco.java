package br.com.db1.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.sql.ordering.antlr.Factory;
import org.junit.Test;

import br.com.db1.start.classe.Cidade;
import br.com.db1.start.classe.Endereco;
import br.com.db1.start.tipo.TipoEndereco;
import br.com.db1.start.tipo.TipoLogradouro;
import br.com.db1.start.tipo.Uf;

public class MainTestEndereco {

	@Test
	public void metodoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
		
		Cidade cidade = new Cidade();		
		cidade.setId(29);
		cidade.setNome("Maringá");
		cidade.setUf(Uf.PR);
		
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setTipoLogradouro(TipoLogradouro.AVENIDA);
		endereco.setLogradouro("COLOMBO");
		endereco.setNumero("1279");
		endereco.setComplemento("CASA");
		endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
		endereco.setCep("00000-000");
				
		//EntityManager manager = abreConexao();
				
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();

		factory.close();		
		//fechaConexao(manager);
	}

	public EntityManager abreConexao(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();
		return manager;
		
	}
	
	public void fechaConexao(EntityManager factory){
		factory.close();
	}
	
	@Test
	public void deleteTest() {
	/*	EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Cidade cidade = manager.find(Cidade.class, 3L);
		manager.getTransaction().begin();
		manager.remove(cidade);
		manager.getTransaction().commit();

		factory.close();*/

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

	public Cidade getById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Cidade cidade = manager.find(Cidade.class, 13);
        return cidade;
	}
	
	@Test
	public void selectHqlTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("Select e from endereco e");
		List<Endereco> enderecos = query.getResultList();

		factory.close();

	}

	@Test
	public void selectSqlNativoTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNativeQuery("Select e from endereco e");
		List<Endereco> enderecos = query.getResultList();

		factory.close();

	}

}
