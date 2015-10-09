/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.crudJPA.utils;

import com.claudio.crudJPA.entities.BaseEntity;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author claudio
 */
public class GenericService <T extends BaseEntity> {
	
	private Class<T> clazz;

	public GenericService(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T salvar(T c) {
		EntityManagerUtil.begin();
		try {
			if (c.getId() != null)
				return EntityManagerUtil.getEM().merge(c);
			else
				EntityManagerUtil.getEM().persist(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			EntityManagerUtil.commit();
		}
		return c;
	}

	public void excluir(T c) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().remove(c);
		EntityManagerUtil.commit();
	}

	public T buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(clazz, id);
	}
	
	public List<T> buscarTodos() {
		String jpql = "SELECT c FROM " 
				+ clazz.getSimpleName() + " c";

		TypedQuery<T> qry = EntityManagerUtil.getEM()
				.createQuery(jpql, clazz);
		
//		qry.setFirstResult(10);
//		qry.setMaxResults(10);

		return qry.getResultList();
	}
}