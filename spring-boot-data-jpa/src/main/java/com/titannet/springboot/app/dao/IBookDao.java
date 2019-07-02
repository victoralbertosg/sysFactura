package com.titannet.springboot.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.titannet.springboot.app.entity.Book;



public interface IBookDao extends CrudRepository <Book,Long> {
	
	

}
