package com.marta.yotitest.persitence;

import java.sql.SQLException;

public interface Persister<T,K> {
	public K makeKey(T obj); 
	public T select(K value) throws SQLException;
	public T update(T obj) throws SQLException;
	public T create(T obj) throws SQLException;
	public void delete(K value) throws SQLException;
	public void createStore() throws SQLException;
}
