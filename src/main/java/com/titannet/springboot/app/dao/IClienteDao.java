package com.titannet.springboot.app.dao;



import org.springframework.data.repository.CrudRepository;

import com.titannet.springboot.app.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{
	
}
