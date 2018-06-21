package com.demo.services;

import java.util.List;

public interface IService <T, ID> {
	public List<T> findAll();
	
	public T findById(ID id);
	
	public void save(T entity);
	
	public void delete(T entity);
}
