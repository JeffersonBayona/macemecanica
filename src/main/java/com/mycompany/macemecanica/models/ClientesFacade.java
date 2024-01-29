/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Clientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jeffer
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    public long getTotalClientesById() {
        query = em.createQuery("SELECT COUNT(c) FROM Clientes c");
        return (Long) query.getSingleResult();
    }

    public Clientes findById(Integer id) {
        query = em.createQuery("SELECT c FROM Clientes c WHERE c.idCliente = :id")
                .setParameter("id", id);
        Object o = query.getSingleResult();
        return (Clientes) o;
    }

}
