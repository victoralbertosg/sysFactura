package com.titannet.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.springboot.app.dao.IClienteDao;
import com.titannet.springboot.app.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{
	
	@Autowired(required=true)
	private IClienteDao clienteDao;
	
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
}
