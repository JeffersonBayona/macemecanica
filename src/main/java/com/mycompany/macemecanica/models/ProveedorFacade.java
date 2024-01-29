/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Proveedor;
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
public class ProveedorFacade extends AbstractFacade<Proveedor> {
    
    

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    public long getTotalProvidersById() {
        query = em.createQuery("SELECT COUNT(p) FROM Proveedor p");
        return (Long) query.getSingleResult();
    }
    
    public List<Proveedor> findByName(String name, String numdoc){
        query = em.createQuery("SELECT p FROM Proveedor p WHERE p.nombreProveedor = :name OR p.numIdentificacion = :numdoc");
        query.setParameter("name", name);
        query.setParameter("numdoc", numdoc);
        return query.getResultList();
    }

    public List<Proveedor> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
