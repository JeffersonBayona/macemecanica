/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jeffer
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public long getTotalCategoria() {
        query = em.createQuery("SELECT COUNT(c) FROM Categoria c");
        return (Long) query.getSingleResult();
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }

}
