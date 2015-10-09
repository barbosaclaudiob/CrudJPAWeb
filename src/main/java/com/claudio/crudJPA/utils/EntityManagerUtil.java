package com.claudio.crudJPA.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory emf;
	private static EntityManager em = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	public static EntityManager getEM() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}
	
	public static void begin() {
		if (!getEM().getTransaction().isActive())
			getEM().getTransaction().begin();
	}
	
	public static void commit() {
		getEM().getTransaction().commit();
	}
	
	public static void close() {
		emf.close();
	}

}