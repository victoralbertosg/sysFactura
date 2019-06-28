package com.titannet.springboot.app.service;

import java.util.List;

import com.titannet.springboot.app.entity.Producto;


public interface IProductoService {
	public List<Producto> findall();
	public List<Producto> findByNombre(String term);
}
