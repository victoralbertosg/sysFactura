package com.titannet.springboot.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.titannet.springboot.app.entity.Producto;
import com.titannet.springboot.app.entity.book;

public interface IBook extends CrudRepository<book, Long> {

}
