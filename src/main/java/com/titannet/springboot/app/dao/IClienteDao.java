package com.titannet.springboot.app.dao;

import java.util.List;

import com.titannet.springboot.app.entity.Cliente;

public interface IClienteDao {
public List<Cliente> findAll();
public void save (Cliente cliente);
public Cliente findOne (Long id);


}
