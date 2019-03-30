package com.titannet.springboot.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.titannet.springboot.app.entity.Cliente;
import javax.persistence.PersistenceContext;

@Repository
public class ClienteDaoImp implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {		
		return em.createQuery("from Cliente").getResultList();
	}

}
