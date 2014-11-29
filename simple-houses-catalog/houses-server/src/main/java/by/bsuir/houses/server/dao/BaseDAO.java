package by.bsuir.houses.server.dao;

import java.util.List;

public abstract class BaseDAO<T> {
	
	abstract  List<T> findAll() throws  HouseApplicationSQLException;
	abstract  T findEntityById(int id) throws  HouseApplicationSQLException;
	abstract  boolean delete(int id) throws  HouseApplicationSQLException;
	abstract  T create(T entity) throws  HouseApplicationSQLException;
	abstract  T update(T entity) throws  HouseApplicationSQLException;

}
