package com.titannet.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titannet.springboot.app.dao.IProductoDao;
import com.titannet.springboot.app.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<Producto> findall() {
		return (List<Producto>) productoDao.findAll() ;		
	}

	@Override
	public List<Producto> findByNombre( String term) {
		return (List<Producto>) productoDao.findByNombre(term);		
	}	
	
}
