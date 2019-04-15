package com.titannet.springboot.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.springboot.app.entity.Cliente;


@Repository
public class ClienteDaoImp implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {		
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if (cliente.getId()!=null && cliente.getId()>0) {
			em.merge(cliente);
			}
		else {
			em.persist(cliente);
		}		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		return em.find(Cliente.class,id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Cliente cliente =findOne(id);
		em.remove(cliente);		
	}

}
