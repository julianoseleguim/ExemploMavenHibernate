package br.com.db1.start.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.start.classe.Cidade;
import br.com.db1.start.dao.DAO;

public class CidadeDao implements DAO<Cidade>{

	@Inject
	private EntityManager entityManager;
	
	public List<Cidade> findAll() {
		// TODO Auto-generated method stub
		return entityManager.
				createQuery("select from cidade").
				getResultList();
	}

	public Cidade findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cidade> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Cidade t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
