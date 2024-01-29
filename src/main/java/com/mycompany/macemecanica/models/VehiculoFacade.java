/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Vehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeffer
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
}
