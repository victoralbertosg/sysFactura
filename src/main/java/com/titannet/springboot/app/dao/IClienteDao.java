package com.titannet.springboot.app.dao;




import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.springboot.app.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long>{
	
}
