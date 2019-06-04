package com.titannet.springboot.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.springboot.app.dao.IClienteDao;
import com.titannet.springboot.app.dao.IProductoDao;
import com.titannet.springboot.app.entity.Cliente;
import com.titannet.springboot.app.entity.Producto;

@Service
public class ClienteServiceImp implements IClienteService{
	
	@Autowired(required=true)
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public Cliente findOne(Long id) {		
		return  clienteDao.findById(id).get();		
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombre(term);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombreLikeIgnoreCase(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}
}
