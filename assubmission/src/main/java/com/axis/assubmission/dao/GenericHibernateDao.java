package com.axis.assubmission.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;

public abstract class GenericHibernateDao<T, ID extends Serializable>
		implements GenericDao<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	public GenericHibernateDao() {

		Type[] types = ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments();
		this.persistentClass = (Class<T>) types[0];
	}

	@Override
	public T get(ID id, boolean lock) {
		@SuppressWarnings("unchecked")
		T entity = (T) session.load(getPersistentClass(), id);
		return entity;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(T t, String... excludeProperties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T saveOrUpdate(T t) {
		getCurrentSession().saveOrUpdate(t);
		return t;
	}

	@Override
	public T detach(T t) {
		getCurrentSession().delete(t);
		return t;
	}

	@Override
	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public void clear() {
		getCurrentSession().clear();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	protected Session getCurrentSession() {
		if (null == session) {
			session = HibernateUtil.getSessionFactoryInstance()
					.getCurrentSession();
		}
		return session;
	}

	@Override
	public Class<?> getPersistentClass() {
		return persistentClass;
	}

}
