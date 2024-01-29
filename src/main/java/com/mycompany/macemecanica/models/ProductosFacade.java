/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jeffer
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    public List<Productos> findByName(String name) {
        query = em.createQuery("SELECT p FROM Productos p WHERE p.nombreProducto = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Productos> filtro(Integer categoriaId) {
        query = em.createQuery("SELECT p FROM Productos p WHERE p.categoriaIdcategoria.idcategoria = :categoriaId");
        query.setParameter("categoriaId", categoriaId);
        return query.getResultList();
    }

    public Productos findById(Integer id) {
        query = em.createQuery("SELECT p FROM Productos p WHERE p.idproductos = :id")
                .setParameter("id", id);
        Object o = query.getSingleResult();
        return (Productos) o;
    }
    
    public long getTotalProduct() {
        query = em.createQuery("SELECT COUNT(p) FROM Productos p");
        return (Long) query.getSingleResult();
    }
}
