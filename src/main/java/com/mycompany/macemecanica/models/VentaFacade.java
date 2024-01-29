/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.mycompany.macemecanica.entitys.Productos;

/**
 *
 * @author Jeffer
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
    public long getTotalVentas() {
        query = em.createQuery("SELECT COUNT(v) FROM Venta v");
        return (Long) query.getSingleResult();
    }
    
}
