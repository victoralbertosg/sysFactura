package com.titannet.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titannet.springboot.app.dao.IBookDao;
import com.titannet.springboot.app.dao.IProductoDao;
import com.titannet.springboot.app.entity.Book;
import com.titannet.springboot.app.entity.Producto;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> findall() {		
		return (List<Book>)bookDao.findAll();
	}




	
	
}
