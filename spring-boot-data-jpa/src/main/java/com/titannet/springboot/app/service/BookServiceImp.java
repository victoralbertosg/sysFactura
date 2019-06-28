package com.titannet.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titannet.springboot.app.dao.IBook;
import com.titannet.springboot.app.entity.book;



@Service
public class BookServiceImp implements IBookService {

	@Autowired
	public IBook mybooks;
	
	@Override
	public List<book> findAll() {
		return (List<book>) mybooks.findAll();		
	}

}
