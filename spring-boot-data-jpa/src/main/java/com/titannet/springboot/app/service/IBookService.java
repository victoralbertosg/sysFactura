package com.titannet.springboot.app.service;

import java.util.List;

import com.titannet.springboot.app.entity.book;

public interface IBookService {
	public List<book> findAll();
}
