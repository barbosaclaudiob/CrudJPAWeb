/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.crudJPA.utils;

import com.claudio.crudJPA.entities.BaseEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author claudio
 *
 */
public class GenericService<T extends BaseEntity> {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    public EntityManager getEM() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public void begin() {
        if (!getEM().getTransaction().isActive()) {
            getEM().getTransaction().begin();
        }
    }

    public void commit() {
        getEM().getTransaction().commit();
    }

    public void close() {
        emf.close();
    }

    private Class<T> clazz;

    public GenericService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T salvar(T c) {

        begin();
        try {
            if (c.getId() != null) {
                return getEM().merge(c);
            } else {
                getEM().persist(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            commit();
        }
        return c;
    }

    public void excluir(T c) {
       begin();
       getEM().remove(c);
       commit();
    }

    public T buscarPorId(Long id) {
        return getEM().find(clazz, id);
    }

    public List<T> buscarTodos() {
        String jpql = "SELECT c FROM "
                + clazz.getSimpleName() + " c";

        TypedQuery<T> qry = getEM()
                .createQuery(jpql, clazz);

//		qry.setFirstResult(10);
//		qry.setMaxResults(10);
        return qry.getResultList();
    }
}
