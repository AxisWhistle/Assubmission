package com.axis.assubmission.dao;


public interface GenericDao<T, ID> {

	T get(ID id, boolean lock);

	Integer count();

	T get(T t, String... excludeProperties);

	T saveOrUpdate(T t);

	T detach(T t);

	void flush();

	void clear();

	Class<?> getPersistentClass();
}
