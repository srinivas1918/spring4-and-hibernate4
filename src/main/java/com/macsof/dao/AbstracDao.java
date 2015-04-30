package com.macsof.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

/**
 * 
 * @author $ Nalla
 *
 * @param <E> Entity 
 * @param <I> DataType
 */
public interface AbstracDao<E, I extends Serializable> {

	I save(E e);
	
	void saveOrupdate(E e);
	
	void delete(E e);
	
	E get(I i);
	
	List<E> find(Query qry);
	
	void saveAll(List<E> e);
	
}
