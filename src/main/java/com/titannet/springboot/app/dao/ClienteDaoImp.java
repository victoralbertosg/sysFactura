package com.titannet.springboot.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.titannet.springboot.app.entity.Cliente;

@Repository
@Qualifier("clienteDao")
public class ClienteDaoImp implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {
		Cliente cliente = findOne(id);
		em.remove(cliente);
	}

}
