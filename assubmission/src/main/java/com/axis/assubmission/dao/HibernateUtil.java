package com.axis.assubmission.dao;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

public class HibernateUtil {
	private static Configuration configuration = new Configuration();
	private static SessionFactory sessionFactory;
	static {
		configuration.configure();
		Reflections reflection = new Reflections("com.axis.assubmission.entity");
		Set<Class<?>> classSet = reflection
				.getTypesAnnotatedWith(javax.persistence.Entity.class);
		for (Class<?> clazz : classSet) {
			configuration.addAnnotatedClass(clazz);
		}

		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}

	private HibernateUtil() {
		throw new RuntimeException("constructor can not be invoked");
	}

	public static SessionFactory getSessionFactoryInstance() {
		return sessionFactory;
	}
}
