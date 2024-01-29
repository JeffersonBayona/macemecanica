/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.VentaHasProductos;
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
public class VentaHasProductosFacade extends AbstractFacade<VentaHasProductos> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaHasProductosFacade() {
        super(VentaHasProductos.class);
    }
    
    public List<VentaHasProductos> findByName(String name){
        query = em.createQuery("SELECT v FROM VentaHasProductos v WHERE v.cantidad = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
    
}
